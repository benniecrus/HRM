package com.iist.hrm.dto.response;

import com.iist.hrm.utils.Constants;

public class AuthenticationResponseDto {
	private String token;
	private String username;
	private String tokenType = Constants.TOKEN_PREFIX;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

}
