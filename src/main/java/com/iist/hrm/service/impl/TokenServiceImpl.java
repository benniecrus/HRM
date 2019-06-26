package com.iist.hrm.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iist.hrm.model.Token;
import com.iist.hrm.repository.TokenRepository;
import com.iist.hrm.service.TokenService;

@Service
@Transactional
public class TokenServiceImpl implements TokenService {
	
	private static final Logger logger = LoggerFactory.getLogger(TokenServiceImpl.class);
	
	@Autowired
	private TokenRepository tokenRepository;
	
	@Override
	public void saveToken(String token, String username, Date expiredTime) {
		logger.debug("Start save new token");
		Token tokenObj = new Token();
		tokenObj.setToken(token);
		tokenObj.setUsername(username);
		tokenObj.setActive(true);
		tokenObj.setExpiredTime(expiredTime);
		logger.debug("Save token: " + tokenObj.toString());
		tokenRepository.saveAndFlush(tokenObj);
		logger.debug("End save new token");
	}

	@Override
	public void cleanExpiredToken() {
		logger.debug("Start clean expired time token");
		List<Token> tokenList = tokenRepository.findTokenExpiredOrInactive(new Date());
		logger.debug("Remove {} token ", tokenList.size());
		tokenRepository.deleteAll(tokenList);
		logger.debug("End clean expired time token");
	}
}
