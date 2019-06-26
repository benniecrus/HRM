package com.iist.hrm.dto.response;

import com.iist.hrm.dto.CategoryDto;

public class ResponseDto<T> {
	private String message;
//	private int status;
	private T content;
	
	private CategoryDto dto;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	public int getStatus() {
//		return status;
//	}
//
//	public void setStatus(int status) {
//		this.status = status;
//	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public CategoryDto getDto() {
		return dto;
	}

	public void setDto(CategoryDto dto) {
		this.dto = dto;
	}

	
}
