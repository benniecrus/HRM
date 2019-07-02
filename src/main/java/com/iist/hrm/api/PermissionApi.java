package com.iist.hrm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iist.hrm.dto.PermissionDto;
import com.iist.hrm.dto.request.RolePermissionDto;
import com.iist.hrm.dto.response.ResponseDto;
import com.iist.hrm.service.PermissionService;
import com.iist.hrm.utils.Constants;

@RestController
@RequestMapping("/api/permission")
public class PermissionApi {

	@Autowired
	private PermissionService permissionService;

	@PostMapping("/get-permission-by-role")
	public ResponseEntity<ResponseDto<List<PermissionDto>>> getPermissionByRole(
			@RequestBody(required = true) RolePermissionDto requestDto) {
		ResponseDto<List<PermissionDto>> response = new ResponseDto<List<PermissionDto>>();

		List<PermissionDto> permissionDtoList = permissionService.getPermissionByRole(requestDto.getRoleId());
		response.setContent(permissionDtoList);
		response.setMessage(Constants.SUCCESS);

		return new ResponseEntity<ResponseDto<List<PermissionDto>>>(response, HttpStatus.OK);
	}
}
