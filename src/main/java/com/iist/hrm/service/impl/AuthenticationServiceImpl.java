package com.iist.hrm.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.iist.hrm.dto.AccountDto;
import com.iist.hrm.dto.request.AuthenticationRequestDto;
import com.iist.hrm.dto.response.AuthenticationResponseDto;
import com.iist.hrm.jwt.JwtTokenProvider;
import com.iist.hrm.model.Token;
import com.iist.hrm.repository.TokenRepository;
import com.iist.hrm.service.AuthenticationService;
import com.iist.hrm.service.TokenService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Value("${security.jwt.token.expired-time}")
	private long expiredTime = 3600000;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private TokenRepository tokenRepository;

	@Override
	public AuthenticationResponseDto authenticateUser(AuthenticationRequestDto authenticationRequestDto) {

		UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(
				authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword());

		Authentication authentication = authenticationManager.authenticate(user);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		AccountDto account = (AccountDto) authentication.getPrincipal();
		
		Date now = new Date();
		Date validateTime = new Date(now.getTime() + expiredTime);
		
		String token = jwtTokenProvider.createToken(account.getUsername(), account.getRoles(), validateTime);

		tokenService.saveToken(token, account.getUsername(), validateTime);

		AuthenticationResponseDto authenticationResponseDto = new AuthenticationResponseDto();

		authenticationResponseDto.setToken(token);
		authenticationResponseDto.setUsername(account.getUsername());

		return authenticationResponseDto;
	}

	@Override
	public boolean logout(String token) {
		Token tokenObj = tokenRepository.findByToken(token);
		if (tokenObj == null) {
			return false;
		}
		tokenObj.setActive(false);
		tokenRepository.saveAndFlush(tokenObj);
		return true;
	}

}
