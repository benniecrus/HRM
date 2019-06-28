package com.iist.hrm.dto.response;

public class ResponseDto<T> {
	private String message;
	private T content;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

}
