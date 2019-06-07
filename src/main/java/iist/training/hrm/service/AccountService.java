package iist.training.hrm.service;

import iist.training.hrm.model.Account;

public interface AccountService {
	Account getAccountByUsernameAndPassword(String username, String password);
	Account getAccountInfo(String username);
}
