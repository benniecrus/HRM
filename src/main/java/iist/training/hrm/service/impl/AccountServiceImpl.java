package iist.training.hrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import iist.training.hrm.model.Account;
import iist.training.hrm.model.Role;
import iist.training.hrm.repository.AccountRepository;
import iist.training.hrm.repository.RoleRepository;
import iist.training.hrm.service.AccountService;
import iist.training.hrm.utils.Constants;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Account getAccountByUsernameAndPassword(String username, String password) {
		Account account = accountRepository.findByUsernameAndPassword(username, password);
		return account;
	}

	@Override
	public Account getAccountInfo(String username) {
		Account account = accountRepository.getAccounInfo(username);
		return account;
	}
	
	public Account addNewAccount(String username, String password) {
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(passwordEncoder.encode(password));
		
		Role role = roleRepository.findByRoleName(Constants.ROLE_USER);
		
		account.setRole(role);
		
		account = accountRepository.saveAndFlush(account);
		
		return account;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.getAccounInfo(username);
		return account;
	}
	
}
