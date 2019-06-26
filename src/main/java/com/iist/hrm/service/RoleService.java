package com.iist.hrm.service;

import java.util.List;

import com.iist.hrm.dto.RoleDto;
import com.iist.hrm.dto.request.NewRoleDto;

public interface RoleService {
	RoleDto addNewRole(NewRoleDto newRoleDto);
	RoleDto updateRole(NewRoleDto newRoleDto);
	List<RoleDto> getAllRole();
}
