package iist.training.hrm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import iist.training.hrm.dto.request.RegisterRequestDto;
import iist.training.hrm.model.Account;
import iist.training.hrm.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountApi {

	@Autowired
	AccountService accountService;

	@GetMapping("/getaccount")
	public Account getAccount(@RequestParam(name = "userName", required = true) String userName,
			@RequestParam(name = "password", required = true) String password) {
		Account account = accountService.getAccountByUsernameAndPassword(userName, password);
		return account;
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<?> registerAccount(@RequestBody(required = true) RegisterRequestDto registerRequestDto) {
		Account account = accountService.addNewAccount(registerRequestDto.getUsername(), registerRequestDto.getPassword());
		
		return new ResponseEntity<Account>(account, HttpStatus.OK);
		
	}
	
}
