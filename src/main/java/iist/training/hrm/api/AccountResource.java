package iist.training.hrm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import iist.training.hrm.model.Account;
import iist.training.hrm.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountResource {

	@Autowired
	AccountService accountService;

	@GetMapping("/account")
	public Account getAccount(@RequestParam(name = "userName", required = true) String userName,
			@RequestParam(name = "password", required = true) String password) {
		Account account = accountService.getAccountByUsernameAndPassword(userName, password);
		return account;
	}
}
