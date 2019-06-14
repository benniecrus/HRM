package iist.training.hrm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iist.training.hrm.dto.RoleDto;
import iist.training.hrm.dto.request.NewRoleDto;
import iist.training.hrm.dto.response.ResponseDto;
import iist.training.hrm.service.RoleService;

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
		response.setMessage("Success");
		return new ResponseEntity<ResponseDto<RoleDto>>(response, HttpStatus.OK);
	}
	
	@PostMapping("/update-role")
	public ResponseEntity<ResponseDto<RoleDto>> updateRole(@RequestBody(required = true) NewRoleDto newRoleDto) {
		ResponseDto<RoleDto> response = new ResponseDto<RoleDto>();
		RoleDto roleDto = roleService.updateRole(newRoleDto);
		response.setContent(roleDto);
		response.setMessage("Success");
		return new ResponseEntity<ResponseDto<RoleDto>>(response, HttpStatus.OK);
	}
}
