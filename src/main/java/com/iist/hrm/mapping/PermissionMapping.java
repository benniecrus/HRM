package com.iist.hrm.mapping;

import com.iist.hrm.dto.PermissionDto;
import com.iist.hrm.dto.request.NewPermissionDto;
import com.iist.hrm.model.Permission;

public class PermissionMapping {
	public static Permission newPermissionDtoToPermission(NewPermissionDto newPermissionDto) {
		if (newPermissionDto != null) {
			Permission permission = new Permission();
			permission.setPermissionId(newPermissionDto.getPermissionId());
			permission.setPermissionName(newPermissionDto.getPermissionName());
			permission.setPermissionDescription(newPermissionDto.getPermissionDescription());
		}
		return null;
	}
	
	public static PermissionDto permissionToPermissionDto(Permission permission) {
		if (permission != null) {
			PermissionDto permissionDto = new PermissionDto();
			permissionDto.setPermissionId(permission.getPermissionId());
			permissionDto.setPermissionName(permission.getPermissionName());
			permissionDto.setPermissionDescription(permission.getPermissionDescription());
		}
		return null;
	}
}
