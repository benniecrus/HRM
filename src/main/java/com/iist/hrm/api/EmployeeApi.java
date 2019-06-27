package com.iist.hrm.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iist.hrm.dto.EmployeeDto;
import com.iist.hrm.dto.request.SearchEmployeeDto;
import com.iist.hrm.dto.response.ResponseDto;
import com.iist.hrm.mapping.EmployeeMapping;
import com.iist.hrm.service.EmployeeService;
import com.iist.hrm.utils.Constants;

@RestController
@RequestMapping("/api/emp")
public class EmployeeApi {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/search-employee")
	public ResponseEntity<ResponseDto<List<EmployeeDto>>> searchEmployee(
			@RequestParam(name = "ss") String searchString) {
		ResponseDto<List<EmployeeDto>> response = new ResponseDto<List<EmployeeDto>>();

		List<EmployeeDto> employeeDtos = employeeService.searchEmployee(searchString);
		response.setContent(employeeDtos);
		response.setMessage(Constants.SUCCESS);

		return new ResponseEntity<ResponseDto<List<EmployeeDto>>>(response, HttpStatus.OK);
	}

	@GetMapping("/get-employee-by-id")
	public ResponseEntity<ResponseDto<EmployeeDto>> getEmployeeById(@RequestParam(name = "empId") int employeeId) {
		ResponseDto<EmployeeDto> response = new ResponseDto<EmployeeDto>();

		EmployeeDto employeeDtos = EmployeeMapping.employeeToEmployeeDto(employeeService.getEmployeeById(employeeId));
		response.setContent(employeeDtos);
		response.setMessage(Constants.SUCCESS);

		return new ResponseEntity<ResponseDto<EmployeeDto>>(response, HttpStatus.OK);
	}

	@PostMapping("/search-employee-by-position")
	public ResponseEntity<ResponseDto<List<EmployeeDto>>> searchEmployeeByPosition(
			@RequestBody(required = true) SearchEmployeeDto searchEmployeeDto) {
		ResponseDto<List<EmployeeDto>> response = new ResponseDto<List<EmployeeDto>>();

		List<EmployeeDto> employeeDtos = employeeService.searchEmployeeByPosition(searchEmployeeDto.getPositionId());
		response.setContent(employeeDtos);
		response.setMessage(Constants.SUCCESS);

		return new ResponseEntity<ResponseDto<List<EmployeeDto>>>(response, HttpStatus.OK);
	}

}
