package iist.training.hrm.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewRoleDto {
	private int roleId;
	@NotBlank
	@Size(max = 255)
	private String roleName;
	@Size(max = 255)
	private String roleDescription;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
