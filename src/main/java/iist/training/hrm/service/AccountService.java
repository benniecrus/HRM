package iist.training.hrm.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import iist.training.hrm.dto.AccountDto;

public interface AccountService extends UserDetailsService {
	AccountDto getAccountByUsernameAndPassword(String username, String password);
	AccountDto getAccountInfo(String username);
	AccountDto addNewAccount(String username, String password);
}
