package iist.training.hrm.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import iist.training.hrm.model.Account;

public interface AccountService extends UserDetailsService {
	Account getAccountByUsernameAndPassword(String username, String password);
	Account getAccountInfo(String username);
	Account addNewAccount(String username, String password);
}
