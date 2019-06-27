package com.iist.hrm.dto.response;

import java.util.Set;

import com.iist.hrm.dto.CategoryDto;

public class ResponseDto<T> {
	private String message;
//	private int status;
	private T content;
	
	private Set<CategoryDto> categories;

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

	public Set<CategoryDto> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryDto> categories) {
		this.categories = categories;
	}


}
