package com.iist.hrm.dto.request;

import javax.validation.constraints.NotBlank;

public class NewPermissionDto {
	private int permissionId;
	@NotBlank(message = "Permission Name cannot blank")
	private String permissionName;
	@NotBlank(message = "Permission description cannot blank")
	private String permissionDescription;

	public int getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionDescription() {
		return permissionDescription;
	}

	public void setPermissionDescription(String permissionDescription) {
		this.permissionDescription = permissionDescription;
	}

}
