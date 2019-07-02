package com.iist.hrm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iist.hrm.dto.PermissionDto;
import com.iist.hrm.dto.request.NewPermissionDto;
import com.iist.hrm.dto.response.ErrorCodes;
import com.iist.hrm.exception.ProductException;
import com.iist.hrm.mapping.PermissionMapping;
import com.iist.hrm.model.Permission;
import com.iist.hrm.model.Role;
import com.iist.hrm.repository.PermissionRepository;
import com.iist.hrm.repository.RoleRepository;
import com.iist.hrm.service.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public PermissionDto addNewPermission(NewPermissionDto newPermissionDto) {
		Permission permission = PermissionMapping.newPermissionDtoToPermission(newPermissionDto);

		permission = permissionRepository.saveAndFlush(permission);

		return PermissionMapping.permissionToPermissionDto(permission);
	}

	@Override
	public List<PermissionDto> getAllPermission() {
		List<Permission> permissionList = permissionRepository.findAll();
		return permissionList.stream().map(permission -> PermissionMapping.permissionToPermissionDto(permission))
				.collect(Collectors.toList());
	}

	@Override
	public List<PermissionDto> getPermissionByRole(int id) {
		Optional<Role> roleOptional = roleRepository.findById(id);
		if (!roleOptional.isPresent()) {
			throw new ProductException("Cannot find role with ID: " + id, ErrorCodes.NOTFOUND.getErrorCode());
		}
		Role role = roleOptional.get();
		List<Permission> permissionList = role.getPermissions();

		if (permissionList.isEmpty()) {
			return new ArrayList<PermissionDto>();
		}

		return permissionList.stream().map(permission -> PermissionMapping.permissionToPermissionDto(permission))
				.collect(Collectors.toList());
	}

}
