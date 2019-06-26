package com.iist.hrm.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iist.hrm.model.Token;
import com.iist.hrm.repository.TokenRepository;
import com.iist.hrm.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {
	
	@Autowired
	private TokenRepository tokenRepository;
	
	@Override
	public void saveToken(String token, String username, Date expiredTime) {
		Token tokenObj = new Token();
		tokenObj.setToken(token);
		tokenObj.setUsername(username);
		tokenObj.setActive(true);
		tokenObj.setExpiredTime(expiredTime);
		tokenRepository.saveAndFlush(tokenObj);
	}

	@Override
	public void cleanExpiredToken() {
		// TODO Auto-generated method stub
		
	}
}
