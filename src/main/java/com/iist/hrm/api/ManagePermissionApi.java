package com.iist.hrm.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iist.hrm.dto.PermissionDto;
import com.iist.hrm.dto.RoleDto;
import com.iist.hrm.dto.request.RolePermissionDto;
import com.iist.hrm.dto.request.NewPermissionDto;
import com.iist.hrm.dto.response.ResponseDto;
import com.iist.hrm.service.PermissionService;
import com.iist.hrm.utils.Constants;

@RestController
@RequestMapping("/api/admin")
public class ManagePermissionApi {

	@Autowired
	private PermissionService permissionService;

	@PostMapping("/add-new-permission")
	public ResponseEntity<ResponseDto<PermissionDto>> addNewPermission(
			@RequestBody(required = true) @Valid NewPermissionDto newPermissionDto) {
		ResponseDto<PermissionDto> response = new ResponseDto<PermissionDto>();

		PermissionDto permissionDto = permissionService.addNewPermission(newPermissionDto);
		response.setContent(permissionDto);
		response.setMessage(Constants.SUCCESS);

		return new ResponseEntity<ResponseDto<PermissionDto>>(response, HttpStatus.OK);
	}

	@GetMapping("/get-all-permission")
	public ResponseEntity<ResponseDto<List<PermissionDto>>> getAllPermission() {
		ResponseDto<List<PermissionDto>> response = new ResponseDto<List<PermissionDto>>();

		List<PermissionDto> permissionList = permissionService.getAllPermission();

		response.setContent(permissionList);
		response.setMessage(Constants.SUCCESS);

		return new ResponseEntity<ResponseDto<List<PermissionDto>>>(response, HttpStatus.OK);
	}

	public ResponseEntity<ResponseDto<RoleDto>> changeRolePermission(
			@RequestBody(required = true) RolePermissionDto requestDto) {

		ResponseDto<RoleDto> response = new ResponseDto<RoleDto>();

		return new ResponseEntity<ResponseDto<RoleDto>>(response, HttpStatus.OK);
	}

}
