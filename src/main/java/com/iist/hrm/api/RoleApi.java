package com.iist.hrm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iist.hrm.dto.RoleDto;
import com.iist.hrm.dto.request.NewRoleDto;
import com.iist.hrm.dto.response.ResponseDto;
import com.iist.hrm.service.RoleService;
import com.iist.hrm.utils.Constants;

@RestController
@RequestMapping("/api/admin")
public class RoleApi {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/new-role")
	public ResponseEntity<ResponseDto<RoleDto>> addNewRole(@RequestBody(required = true) NewRoleDto newRoleDto) {
		ResponseDto<RoleDto> response = new ResponseDto<RoleDto>();
		RoleDto roleDto = roleService.addNewRole(newRoleDto);
		response.setContent(roleDto);
		response.setMessage(Constants.SUCCESS);
		return new ResponseEntity<ResponseDto<RoleDto>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/update-role")
	public ResponseEntity<ResponseDto<RoleDto>> updateRole(@RequestBody(required = true) NewRoleDto newRoleDto) {
		ResponseDto<RoleDto> response = new ResponseDto<RoleDto>();
		RoleDto roleDto = roleService.updateRole(newRoleDto);
		response.setContent(roleDto);
		response.setMessage(Constants.SUCCESS);
		return new ResponseEntity<ResponseDto<RoleDto>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/get-all-role")
	public ResponseEntity<ResponseDto<List<RoleDto>>> getAllRole() {
		ResponseDto<List<RoleDto>> response = new ResponseDto<List<RoleDto>>();
		
		List<RoleDto> roleDtos = roleService.getAllRole();
		response.setContent(roleDtos);
		response.setMessage(Constants.SUCCESS);
		
		return new ResponseEntity<ResponseDto<List<RoleDto>>>(response, HttpStatus.OK);
	}
}
