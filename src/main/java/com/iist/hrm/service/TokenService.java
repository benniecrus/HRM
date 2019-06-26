package com.iist.hrm.service;

import java.util.Date;

public interface TokenService {

	void saveToken(String token, String username, Date expiredTime);
	
	void cleanExpiredToken();
	
}
