package com.iist.hrm.service;

import java.util.Set;

import com.iist.hrm.dto.CategoryDto;

public interface CategoryService {

	Set<CategoryDto> getCategoryByRole(String roleName);
}
