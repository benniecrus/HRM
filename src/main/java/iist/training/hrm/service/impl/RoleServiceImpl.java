package iist.training.hrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iist.training.hrm.dto.RoleDto;
import iist.training.hrm.dto.request.NewRoleDto;
import iist.training.hrm.exception.ProductException;
import iist.training.hrm.mapping.RoleMapping;
import iist.training.hrm.model.Role;
import iist.training.hrm.repository.RoleRepository;
import iist.training.hrm.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

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
		if(newRoleDto.getRoleId() > 0) {
			
			Role role = roleRepository.getOne(newRoleDto.getRoleId());
			
			if(role == null) {
				throw new ProductException("Error update role");
			}
			
			role.setRoleName(newRoleDto.getRoleName());
			role.setDescription(newRoleDto.getRoleDescription());
			
			role = roleRepository.saveAndFlush(role);
			
			if(role == null) {
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

}
