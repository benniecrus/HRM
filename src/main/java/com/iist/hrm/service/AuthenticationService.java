package com.iist.hrm.service;

import com.iist.hrm.dto.request.AuthenticationRequestDto;
import com.iist.hrm.dto.response.AuthenticationResponseDto;

public interface AuthenticationService {
	AuthenticationResponseDto authenticateUser(AuthenticationRequestDto authenticationRequestDto);
	boolean logout(String token);
}
