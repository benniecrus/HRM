package iist.training.hrm.api;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.tomcat.websocket.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iist.training.hrm.dto.EmployeeDto;
import iist.training.hrm.dto.request.ChangeEmployeeDto;
import iist.training.hrm.dto.request.NewEmployeeDto;
import iist.training.hrm.dto.response.ResponseDto;
import iist.training.hrm.service.EmployeeService;

@RestController
@RequestMapping("/api/manage")
public class ManageEmployeeApi {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add-employee")
	public ResponseEntity<ResponseDto<EmployeeDto>> addEmployee(HttpServletRequest request,
			@RequestBody(required = true) @Valid NewEmployeeDto newEmployee) throws ParseException {
		ResponseDto<EmployeeDto> response = new ResponseDto<EmployeeDto>();

		if (StringUtils.isEmpty(request.getHeader(Constants.AUTHORIZATION_HEADER_NAME))) {

		}

		EmployeeDto employeeDto = employeeService.addEmployee(newEmployee);
		response.setContent(employeeDto);
		response.setMessage("Success");

		return new ResponseEntity<ResponseDto<EmployeeDto>>(response, HttpStatus.OK);
	}

	@GetMapping("/list-employee")
	public ResponseEntity<ResponseDto<List<EmployeeDto>>> getListEmployee(HttpServletRequest request) {

		ResponseDto<List<EmployeeDto>> response = new ResponseDto<List<EmployeeDto>>();

		if (StringUtils.isEmpty(request.getHeader(Constants.AUTHORIZATION_HEADER_NAME))) {

		}

		return new ResponseEntity<ResponseDto<List<EmployeeDto>>>(response, HttpStatus.OK);
	}

	@PostMapping("/update-employee-information")
	public ResponseEntity<ResponseDto<EmployeeDto>> updateEmployeeInformation(
			@RequestBody(required = true) @Valid NewEmployeeDto updateEmployeeDto) throws ParseException {
		ResponseDto<EmployeeDto> response = new ResponseDto<EmployeeDto>();

		EmployeeDto employeeDto = employeeService.updateEmployee(updateEmployeeDto);

		response.setContent(employeeDto);
		response.setMessage("Success");

		return new ResponseEntity<ResponseDto<EmployeeDto>>(response, HttpStatus.OK);
	}

	@PostMapping("/change-employee-status")
	public ResponseEntity<ResponseDto<EmployeeDto>> updateEmployeeStatus(
			@RequestBody(required = true) @Valid ChangeEmployeeDto changeEmployeeStatusDto) {
		ResponseDto<EmployeeDto> response = new ResponseDto<EmployeeDto>();

		EmployeeDto employeeDto = employeeService.updateEmployeeStatus(changeEmployeeStatusDto);

		response.setContent(employeeDto);
		response.setMessage("Success");

		return new ResponseEntity<ResponseDto<EmployeeDto>>(response, HttpStatus.OK);
	}

	@PostMapping("/change-employee-position")
	public ResponseEntity<ResponseDto<EmployeeDto>> updateEmployeePosition(
			@RequestBody(required = true) @Valid ChangeEmployeeDto changeEmployeeStatusDto) {
		ResponseDto<EmployeeDto> response = new ResponseDto<EmployeeDto>();

		EmployeeDto employeeDto = employeeService.updateEmployeePosition(changeEmployeeStatusDto);

		response.setContent(employeeDto);
		response.setMessage("Success");

		return new ResponseEntity<ResponseDto<EmployeeDto>>(response, HttpStatus.OK);
	}
}
