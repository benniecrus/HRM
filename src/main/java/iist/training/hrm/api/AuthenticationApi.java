package iist.training.hrm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iist.training.hrm.dto.request.AuthenticationRequestDto;
import iist.training.hrm.dto.response.AuthenticationResponseDto;
import iist.training.hrm.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationApi {
	
	@Autowired
	private AuthenticationService authenticationService; 
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponseDto> authenticateUser(
			@RequestBody(required = true) AuthenticationRequestDto authenticationRequestDto) {
		
		AuthenticationResponseDto authenResponse = authenticationService.authenticateUser(authenticationRequestDto);
		
		return new ResponseEntity<AuthenticationResponseDto>(authenResponse, HttpStatus.OK);
	}

}
