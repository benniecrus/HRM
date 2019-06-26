package com.iist.hrm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.iist.hrm.dto.RoleDto;
import com.iist.hrm.dto.request.NewRoleDto;
import com.iist.hrm.exception.ProductException;
import com.iist.hrm.mapping.RoleMapping;
import com.iist.hrm.model.Role;
import com.iist.hrm.repository.RoleRepository;
import com.iist.hrm.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleDto addNewRole(NewRoleDto newRoleDto) {
		if (!checkIsExistRoleName(newRoleDto.getRoleName())) {
			Role role = new Role();
			role.setRoleName(newRoleDto.getRoleName());
			role.setDescription(newRoleDto.getRoleDescription());
			role = roleRepository.saveAndFlush(role);
			return RoleMapping.mappingRole(role);
		} else {
			throw new ProductException("Role name has been existed.");
		}

	}

	@Override
	public RoleDto updateRole(NewRoleDto newRoleDto) {
		if (newRoleDto.getRoleId() > 0) {

			Optional<Role> roleOptional = roleRepository.findById(newRoleDto.getRoleId());

			if (!roleOptional.isPresent()) {
				throw new ProductException("Error update role");
			}

			Role role = roleOptional.get();

			role.setRoleName(newRoleDto.getRoleName());
			role.setDescription(newRoleDto.getRoleDescription());

			role = roleRepository.saveAndFlush(role);

			if (role == null) {
				throw new ProductException("Error update role");
			}

			return RoleMapping.mappingRole(role);
		} else {
			throw new ProductException("Role ID must > 0");
		}

	}

	public boolean checkIsExistRoleName(String roleName) {
		Role role = roleRepository.findByRoleName(roleName);
		if (role == null) {
			return false;
		}
		return true;
	}

	@Override
	public List<RoleDto> getAllRole() {
		List<Role> roleList = roleRepository.findAll();
		if (CollectionUtils.isEmpty(roleList)) {
			return new ArrayList<RoleDto>();
		}
		return roleList.stream().map(role -> RoleMapping.mappingRole(role)).collect(Collectors.toList());
	}

}
