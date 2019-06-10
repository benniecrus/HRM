package iist.training.hrm.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iist.training.hrm.dto.AccountDto;
import iist.training.hrm.mapping.AccountMapping;
import iist.training.hrm.model.Account;
import iist.training.hrm.model.Role;
import iist.training.hrm.repository.AccountRepository;
import iist.training.hrm.repository.RoleRepository;
import iist.training.hrm.service.AccountService;
import iist.training.hrm.utils.Constants;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
	
}
