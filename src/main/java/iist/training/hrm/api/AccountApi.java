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

import iist.training.hrm.dto.AccountDto;
import iist.training.hrm.dto.request.RegisterRequestDto;
import iist.training.hrm.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountApi {

	@Autowired
	AccountService accountService;

	@GetMapping("/getaccount")
	public AccountDto getAccount(@RequestParam(name = "userName", required = true) String userName,
			@RequestParam(name = "password", required = true) String password) {
		AccountDto account = accountService.getAccountByUsernameAndPassword(userName, password);
		return account;
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<?> registerAccount(@RequestBody(required = true) RegisterRequestDto registerRequestDto) {
		AccountDto account = accountService.addNewAccount(registerRequestDto.getUsername(), registerRequestDto.getPassword());
		
		return new ResponseEntity<AccountDto>(account, HttpStatus.OK);
		
	}
	
}
