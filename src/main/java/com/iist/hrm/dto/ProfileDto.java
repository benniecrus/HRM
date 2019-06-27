package com.iist.hrm.dto;

import java.io.Serializable;
import java.util.Set;

public class ProfileDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private AccountDto accountDto;
	
	private Set<CategoryDto> categories ;

	public AccountDto getAccountDto() {
		return accountDto;
	}

	public void setAccountDto(AccountDto accountDto) {
		this.accountDto = accountDto;
	}

	public Set<CategoryDto> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryDto> categories) {
		this.categories = categories;
	}
	
	
}
