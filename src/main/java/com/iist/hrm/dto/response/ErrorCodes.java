package com.iist.hrm.dto.response;

public enum ErrorCodes {
	INVALID("E001"),
	TOKENERROR("E101"),
	NOTFOUND("E201");
	
	private String errorCode;

	private ErrorCodes(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
