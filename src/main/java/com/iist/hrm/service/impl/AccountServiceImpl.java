package com.iist.hrm.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iist.hrm.dto.AccountDto;
import com.iist.hrm.dto.request.ChangeAccountRoleDto;
import com.iist.hrm.dto.request.ChangeAccountStatusDto;
import com.iist.hrm.dto.request.ChangePasswordDto;
import com.iist.hrm.dto.response.ErrorCodes;
import com.iist.hrm.exception.ProductException;
import com.iist.hrm.jwt.JwtTokenProvider;
import com.iist.hrm.mapping.AccountMapping;
import com.iist.hrm.model.Account;
import com.iist.hrm.model.AccountStatus;
import com.iist.hrm.model.Employee;
import com.iist.hrm.model.Role;
import com.iist.hrm.repository.AccountRepository;
import com.iist.hrm.repository.EmployeeRepository;
import com.iist.hrm.repository.RoleRepository;
import com.iist.hrm.service.AccountService;
import com.iist.hrm.utils.CharaterUtils;
import com.iist.hrm.utils.Constants;

import io.jsonwebtoken.Claims;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public AccountDto getAccountByUsername(String username) {
		Account account = accountRepository.getAccounInfo(username);
		
		return AccountMapping.accountMapping(account);
	}

	@Override
	public AccountDto getAccountInfo(String username) {
		Account account = accountRepository.getAccounInfo(username);
		AccountDto accountDto = AccountMapping.buildAccountAuth(account);
		return accountDto;
	}
	
	@Override
	public AccountDto addNewAccount(String username, String password) {
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(passwordEncoder.encode(password));
		
		Role role = roleRepository.findByRoleName(Constants.ROLE_USER);
		
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		
		account.setRoles(roles);
		
		account = accountRepository.saveAndFlush(account);
		
		return AccountMapping.accountMapping(account);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.getAccounInfo(username);
		return AccountMapping.buildAccountAuth(account);
	}

	@Override
	public AccountDto generateAccount(Employee employee) {
		Account account = new Account();
		String accountName = getAccountName(employee.getFirstName(), employee.getLastName());
		int numberOfAccountName = accountRepository.countNumberAccountName(accountName);
		if(numberOfAccountName == 0) {
			account.setUsername(accountName);
		} else {
			account.setUsername(accountName + numberOfAccountName);
		}
		account.setAccountName(accountName);
		account.setPassword(passwordEncoder.encode(Constants.DEFAULT_PASSWORD));
		Role role = roleRepository.findByRoleName(Constants.ROLE_USER);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		account.setRoles(roles);
		account.setEmployee(employee);
		account.setStatus(AccountStatus.ACTIVE.getStatusCode());
		account = accountRepository.saveAndFlush(account);
		employee.setAccount(account);
		employeeRepository.saveAndFlush(employee);
		
		return AccountMapping.accountMapping(account);
	}
	
	private String getAccountName(String firstName, String lastName) {
		String nonUnicodeFirstName = CharaterUtils.nonUnicodeConvert(firstName);
		String nonUnicodeLastName = CharaterUtils.nonUnicodeConvert(lastName);
		String[] splitLastName = nonUnicodeLastName.split(" ");
		StringBuilder employeeName = new StringBuilder(nonUnicodeFirstName);
		for(String s : splitLastName) {
			employeeName.append(s.charAt(0));
		}
		return employeeName.toString();
	}

	@Override
	public AccountDto changePassword(ChangePasswordDto changePasswordDto, String token) {
		
		Claims claim = jwtTokenProvider.getClaimsFromToken(token);
		String username = claim.getSubject();
		
		if(!changePasswordDto.getUsername().equalsIgnoreCase(username)) {
			throw new ProductException("Change password is failed", ErrorCodes.INVALID.getErrorCode());
		}
		
		Account account = accountRepository.getAccounInfo(username);
		
		if(account == null) {
			throw new ProductException("Username is not valid", ErrorCodes.INVALID.getErrorCode());
		}
		
		if(!passwordEncoder.matches(changePasswordDto.getOldPassword(), account.getPassword())) {
			throw new ProductException("Old password is not valid", ErrorCodes.INVALID.getErrorCode());
		}
		
		account.setPassword(changePasswordDto.getNewPassword());
		
		account = accountRepository.saveAndFlush(account);
		
		return AccountMapping.accountMapping(account);
	}

	@Override
	public AccountDto updateAccountRole(ChangeAccountRoleDto changeAccountRoleDto) {
		Optional<Account> optionalAccount = accountRepository.findById(changeAccountRoleDto.getAccountId());
		if(!optionalAccount.isPresent()) {
			throw new ProductException("Not found account", ErrorCodes.NOTFOUND.getErrorCode());
		}
		
		Account account = optionalAccount.get();
		
		if(changeAccountRoleDto.getRoleId().length == 0) {
			throw new ProductException("Account has atleast 1 role", ErrorCodes.INVALID.getErrorCode());
		}
		
		Set<Role> newRoleSet = new HashSet<Role>();
		
		for(Integer roleId : changeAccountRoleDto.getRoleId()) {
			Role role = roleRepository.getOne(roleId);
			if(role == null) {
				throw new ProductException("Role with ID = " + roleId + " is not exist!", ErrorCodes.NOTFOUND.getErrorCode());
			}
			newRoleSet.add(role);
		}
		account.setRoles(newRoleSet);
		
		account = accountRepository.saveAndFlush(account);
		
		return AccountMapping.accountMapping(account);
	}
	
	@Override
	public AccountDto updateAccountStatus(ChangeAccountStatusDto changeAccountStatusDto) {
		Optional<Account> optionalAccount = accountRepository.findById(changeAccountStatusDto.getAccountId());
		if(!optionalAccount.isPresent()) {
			throw new ProductException("Cannot found account", ErrorCodes.NOTFOUND.getErrorCode());
		}
		
		Account account = optionalAccount.get();
		
		account.setStatus(changeAccountStatusDto.getStatusId());
		
		account = accountRepository.saveAndFlush(account);
		
		return AccountMapping.accountMapping(account);
	}

	@Override
	public AccountDto getProfile(String token) {
		Claims claim = jwtTokenProvider.getClaimsFromToken(token);
		String username = claim.getSubject();
		Account account = accountRepository.getAccounInfo(username);
		return AccountMapping.accountMapping(account);
	}
	
}
