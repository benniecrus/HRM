package iist.training.hrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iist.training.hrm.model.Account;
import iist.training.hrm.repository.AccountRepository;
import iist.training.hrm.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account getAccountByUsernameAndPassword(String userName, String password) {
		Account account = accountRepository.findByUserNameAndPassword(userName, password);
		return account;
	}

	@Override
	public Account getAccountInfo(String username) {
		Account account = accountRepository.getAccounInfo(username);
		return account;
	}
	
}
