package com.iist.hrm.dto.request;

import java.util.List;

public class RolePermissionDto {
	private int roleId;
	private List<Integer> permissionId;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public List<Integer> getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(List<Integer> permissionId) {
		this.permissionId = permissionId;
	}

}
