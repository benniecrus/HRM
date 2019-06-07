package iist.training.hrm.service;

import iist.training.hrm.dto.request.AuthenticationRequestDto;
import iist.training.hrm.dto.response.AuthenticationResponseDto;

public interface AuthenticationService {
	public AuthenticationResponseDto authenticateUser(AuthenticationRequestDto authenticationRequestDto);
}
