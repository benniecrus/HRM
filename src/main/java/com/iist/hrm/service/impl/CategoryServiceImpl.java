package com.iist.hrm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.iist.hrm.dto.CategoryDto;
import com.iist.hrm.model.Category;
import com.iist.hrm.model.Role;
import com.iist.hrm.repository.RoleRepository;
import com.iist.hrm.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	RoleRepository roleRespository;
	
	@Override
	public List<CategoryDto> getCategoryByRole(String roleName) {
		Role role = roleRespository.findByRoleName(roleName);
		List<Category> categories = role.getCategories();
		List<CategoryDto> listDto = new ArrayList<CategoryDto>();
		if(!CollectionUtils.isEmpty(categories)) {
			for(Category category : categories) {
				CategoryDto dto = new CategoryDto();
				BeanUtils.copyProperties(category, dto);
				listDto.add(dto);
			}
		}
		
		return listDto;
	}
	
}
