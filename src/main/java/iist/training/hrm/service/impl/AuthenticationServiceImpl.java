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
import iist.training.hrm.model.Token;
import iist.training.hrm.repository.TokenRepository;
import iist.training.hrm.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private TokenRepository tokenRepository;

	@Override
	public AuthenticationResponseDto authenticateUser(AuthenticationRequestDto authenticationRequestDto) {

		UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(
				authenticationRequestDto.getUsername(), authenticationRequestDto.getPassword());

		Authentication authentication = authenticationManager.authenticate(user);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		AccountDto account = (AccountDto) authentication.getPrincipal();

		String token = jwtTokenProvider.createToken(account.getUsername(), account.getRoles());

		saveToken(token, account.getUsername());

		AuthenticationResponseDto authenticationResponseDto = new AuthenticationResponseDto();

		authenticationResponseDto.setToken(token);
		authenticationResponseDto.setUsername(account.getUsername());

		return authenticationResponseDto;
	}

	private void saveToken(String token, String username) {
		Token tokenObj = new Token();
		tokenObj.setToken(token);
		tokenObj.setUsername(username);
		tokenObj.setActive(true);
		tokenRepository.saveAndFlush(tokenObj);
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
