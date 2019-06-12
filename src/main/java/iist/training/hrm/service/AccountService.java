package iist.training.hrm.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import iist.training.hrm.dto.AccountDto;
import iist.training.hrm.model.Account;
import iist.training.hrm.model.Employee;

public interface AccountService extends UserDetailsService {
	AccountDto getAccountByUsername(String username);
	AccountDto getAccountInfo(String username);
	AccountDto addNewAccount(String username, String password);
	AccountDto generateAccount(Employee employee);
}
