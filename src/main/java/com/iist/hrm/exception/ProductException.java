package com.iist.hrm.exception;

public class ProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String message;
	
	public ProductException(String message, String errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
