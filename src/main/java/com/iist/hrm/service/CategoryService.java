package com.iist.hrm.service;

import java.util.List;

import com.iist.hrm.dto.CategoryDto;

public interface CategoryService {

	List<CategoryDto> getCategoryByRole(String roleName);
}
