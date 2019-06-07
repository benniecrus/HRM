package iist.training.hrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		Account account = (Account)authentication.getPrincipal();
		
		String token = jwtTokenProvider.createToken(account.getUsername(), account.getRole().getRoleName());
		
		AuthenticationResponseDto authenticationResponseDto = new AuthenticationResponseDto();
		
		authenticationResponseDto.setToken(token);
		authenticationResponseDto.setUsername(account.getUsername());
		
		return authenticationResponseDto;
	}
	
}
