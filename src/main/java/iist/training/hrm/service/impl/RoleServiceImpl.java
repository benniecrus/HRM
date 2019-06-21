package iist.training.hrm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
		if (newRoleDto.getRoleId() > 0) {

			Optional<Role> roleOptional = roleRepository.findById(newRoleDto.getRoleId());

			if (!roleOptional.isPresent()) {
				throw new ProductException("Error update role");
			}

			Role role = roleOptional.get();

			role.setRoleName(newRoleDto.getRoleName());
			role.setDescription(newRoleDto.getRoleDescription());

			role = roleRepository.saveAndFlush(role);

			if (role == null) {
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

	@Override
	public List<RoleDto> getAllRole() {
		List<Role> roleList = roleRepository.findAll();
		if (CollectionUtils.isEmpty(roleList)) {
			return new ArrayList<RoleDto>();
		}
		return roleList.stream().map(role -> RoleMapping.mappingRole(role)).collect(Collectors.toList());
	}

}
