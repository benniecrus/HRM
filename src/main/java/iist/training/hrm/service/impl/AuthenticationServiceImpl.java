package iist.training.hrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import iist.training.hrm.dto.AccountDto;
import iist.training.hrm.dto.request.AuthenticationRequestDto;
import iist.training.hrm.dto.response.AuthenticationResponseDto;
import iist.training.hrm.jwt.JwtTokenProvider;
import iist.training.hrm.model.Account;
import iist.training.hrm.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Override
	public AuthenticationResponseDto authenticateUser(AuthenticationRequestDto authenticationRequestDto) {
		
		UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword());
		
		Authentication authentication = authenticationManager.authenticate(user);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		AccountDto account = (AccountDto)authentication.getPrincipal();
		
		String token = jwtTokenProvider.createToken(account.getUsername(), account.getRoleName());
		
		AuthenticationResponseDto authenticationResponseDto = new AuthenticationResponseDto();
		
		authenticationResponseDto.setToken(token);
		authenticationResponseDto.setUsername(account.getUsername());
		
		return authenticationResponseDto;
	}
	
}
