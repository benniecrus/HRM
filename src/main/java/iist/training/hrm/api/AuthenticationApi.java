package iist.training.hrm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iist.training.hrm.dto.request.AuthenticationRequestDto;
import iist.training.hrm.dto.response.AuthenticationResponseDto;
import iist.training.hrm.dto.response.ResponseDto;
import iist.training.hrm.service.AuthenticationService;
import iist.training.hrm.utils.Constants;

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

}
