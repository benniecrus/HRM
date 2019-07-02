package com.iist.hrm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iist.hrm.dto.AccountDto;
import com.iist.hrm.dto.request.ChangeAccountRoleDto;
import com.iist.hrm.dto.request.ChangeAccountStatusDto;
import com.iist.hrm.dto.response.ResponseDto;
import com.iist.hrm.service.AccountService;
import com.iist.hrm.utils.Constants;

@RestController
@RequestMapping("api/admin")
public class ManageAccountApi {

	@Autowired
	AccountService accountService;

	@PostMapping("/change-role")
	public ResponseEntity<ResponseDto<AccountDto>> changeAccountRole(
			@RequestBody(required = true) ChangeAccountRoleDto changeAccountRoleDto) {
		ResponseDto<AccountDto> response = new ResponseDto<AccountDto>();

		AccountDto accountDto = accountService.updateAccountRole(changeAccountRoleDto);

		response.setContent(accountDto);
		response.setMessage(Constants.SUCCESS);

		return new ResponseEntity<ResponseDto<AccountDto>>(response, HttpStatus.OK);
	}

	@PostMapping("/change-status")
	public ResponseEntity<ResponseDto<AccountDto>> changeAccountStatus(
			@RequestBody(required = true) ChangeAccountStatusDto changeAccountStatusDto) {
		ResponseDto<AccountDto> response = new ResponseDto<AccountDto>();

		AccountDto accountDto = accountService.updateAccountStatus(changeAccountStatusDto);

		response.setContent(accountDto);
		response.setMessage(Constants.SUCCESS);

		return new ResponseEntity<ResponseDto<AccountDto>>(response, HttpStatus.OK);
	}
}
