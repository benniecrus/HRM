package com.iist.hrm.service;

import java.util.List;

import com.iist.hrm.dto.PermissionDto;
import com.iist.hrm.dto.request.NewPermissionDto;

public interface PermissionService {
	PermissionDto addNewPermission(NewPermissionDto newPermissionDto);
	
	List<PermissionDto> getAllPermission();
	
	List<PermissionDto> getPermissionByRole(int id);
}
