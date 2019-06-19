package iist.training.hrm.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import iist.training.hrm.dto.AccountDto;
import iist.training.hrm.dto.request.ChangePasswordDto;
import iist.training.hrm.dto.response.ResponseDto;
import iist.training.hrm.exception.ProductException;
import iist.training.hrm.service.AccountService;
import iist.training.hrm.utils.Constants;

@RestController
@RequestMapping("/api/account")
public class AccountApi {

	@Autowired
	AccountService accountService;

	@GetMapping("/getaccount")
	public AccountDto getAccount(@RequestParam(name = "username", required = true) String username) {
		AccountDto account = accountService.getAccountByUsername(username);
		return account;
	}

	@PostMapping("/change-password")
	public ResponseEntity<ResponseDto<AccountDto>> changePassword(HttpServletRequest request,
			@RequestBody ChangePasswordDto changePasswordDto) {
		ResponseDto<AccountDto> responseDto = new ResponseDto<AccountDto>();

		if (StringUtils.isEmpty(request.getHeader(Constants.AUTHORIZATION_STRING))) {
			throw new ProductException("Token must be not null");
		}

		String token = request.getHeader(Constants.AUTHORIZATION_STRING).replace(Constants.TOKEN_PREFIX, "").trim();

		AccountDto accountDto = accountService.changePassword(changePasswordDto, token);

		responseDto.setContent(accountDto);
		responseDto.setMessage("Success");

		return new ResponseEntity<ResponseDto<AccountDto>>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/get-profile")
	public ResponseEntity<ResponseDto<AccountDto>> getProfile(HttpServletRequest request) {
		ResponseDto<AccountDto> responseDto = new ResponseDto<AccountDto>();

		if (StringUtils.isEmpty(request.getHeader(Constants.AUTHORIZATION_STRING))) {
			throw new ProductException("Token must be not null");
		}

		String token = request.getHeader(Constants.AUTHORIZATION_STRING).replace(Constants.TOKEN_PREFIX, "").trim();

		AccountDto accountDto = accountService.getProfile(token);

		responseDto.setContent(accountDto);
		responseDto.setMessage("Success");

		return new ResponseEntity<ResponseDto<AccountDto>>(responseDto, HttpStatus.OK);
	}
	
}
