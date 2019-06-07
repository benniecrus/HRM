package iist.training.hrm.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iist.training.hrm.dto.request.AuthenticationRequestDto;
import iist.training.hrm.dto.response.ResponseDto;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationApi {

	@PostMapping
	public ResponseDto<?> authenticateUser(
			@RequestBody(required = true) AuthenticationRequestDto authenticationRequestDto) {
		
		
		
		return null;
	}

}
