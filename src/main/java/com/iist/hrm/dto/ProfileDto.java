package com.iist.hrm.dto;

import java.io.Serializable;
import java.util.List;

public class ProfileDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private AccountDto accountDto;

	private List<CategoryDto> categories;

	public AccountDto getAccountDto() {
		return accountDto;
	}

	public void setAccountDto(AccountDto accountDto) {
		this.accountDto = accountDto;
	}

	public List<CategoryDto> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDto> categories) {
		this.categories = categories;
	}

}
