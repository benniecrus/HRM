package com.iist.hrm.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iist.hrm.dto.request.AuthenticationRequestDto;
import com.iist.hrm.dto.response.AuthenticationResponseDto;
import com.iist.hrm.dto.response.ResponseDto;
import com.iist.hrm.exception.ProductException;
import com.iist.hrm.service.AuthenticationService;
import com.iist.hrm.utils.Constants;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationApi {

	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/login")
	public ResponseEntity<ResponseDto<AuthenticationResponseDto>> authenticateUser(
			@RequestBody(required = true) AuthenticationRequestDto authenticationRequestDto) {
		ResponseDto<AuthenticationResponseDto> response = new ResponseDto<AuthenticationResponseDto>();
		try {
			AuthenticationResponseDto authenResponse = authenticationService.authenticateUser(authenticationRequestDto);
			response.setMessage(Constants.SUCCESS);
			response.setContent(authenResponse);
			return new ResponseEntity<ResponseDto<AuthenticationResponseDto>>(response, HttpStatus.OK);
		} catch (AuthenticationException ex) {
			response.setMessage(Constants.MESSAGE_INVALID_USERNAME_PASSWORD);
			return new ResponseEntity<ResponseDto<AuthenticationResponseDto>>(response, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/logout")
	public ResponseEntity<ResponseDto<String>> logout(HttpServletRequest request) {
		if (StringUtils.isEmpty(request.getHeader(Constants.AUTHORIZATION_STRING))) {
			throw new ProductException("Token must be not null");
		}
		ResponseDto<String> response = new ResponseDto<String>();
		String token = request.getHeader(Constants.AUTHORIZATION_STRING).replace(Constants.TOKEN_PREFIX, "").trim();
		boolean result = authenticationService.logout(token);
		if(!result) {
			throw new ProductException("Logout failed!");
		}
		response.setContent("Log out successfully");
		response.setMessage("Success");
		return new ResponseEntity<ResponseDto<String>>(response, HttpStatus.OK);
	}
	
}
