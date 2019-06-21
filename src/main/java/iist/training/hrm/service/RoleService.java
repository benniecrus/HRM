package iist.training.hrm.service;

import java.util.List;

import iist.training.hrm.dto.RoleDto;
import iist.training.hrm.dto.request.NewRoleDto;

public interface RoleService {
	RoleDto addNewRole(NewRoleDto newRoleDto);
	RoleDto updateRole(NewRoleDto newRoleDto);
	List<RoleDto> getAllRole();
}
