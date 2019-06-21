package iist.training.hrm.service;

import iist.training.hrm.dto.request.AuthenticationRequestDto;
import iist.training.hrm.dto.response.AuthenticationResponseDto;

public interface AuthenticationService {
	AuthenticationResponseDto authenticateUser(AuthenticationRequestDto authenticationRequestDto);
	boolean logout(String token);
}
