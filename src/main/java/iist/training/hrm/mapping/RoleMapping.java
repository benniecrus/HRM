package iist.training.hrm.mapping;

import iist.training.hrm.dto.RoleDto;
import iist.training.hrm.model.Role;

public class RoleMapping {
	public static RoleDto mappingRole(Role role) {
		if (role != null) {
			RoleDto roleDto = new RoleDto();
			roleDto.setRoleId(role.getRoleId());
			roleDto.setRoleName(role.getRoleName());
			roleDto.setDescription(role.getDescription());
			return roleDto;
		}
		return null;
	}
}
