package iist.training.hrm.api;

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
import iist.training.hrm.dto.NewEmployeeDto;
import iist.training.hrm.dto.response.ResponseDto;
import iist.training.hrm.service.EmployeeService;

@RestController
@RequestMapping("/api/manage")
public class ManageEmployeeApi {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add-employee")
	public ResponseEntity<ResponseDto<EmployeeDto>> addEmployee(HttpServletRequest request,
			@RequestBody(required = true) @Valid NewEmployeeDto newEmployee) {
		ResponseDto<EmployeeDto> response = new ResponseDto<EmployeeDto>();

		if (StringUtils.isEmpty(request.getHeader(Constants.AUTHORIZATION_HEADER_NAME))) {
			
		}
		
//		employeeService.addEmployee(newEmployee);

		return new ResponseEntity<ResponseDto<EmployeeDto>>(response, HttpStatus.OK);
	}

	@GetMapping("/list-employee")
	public ResponseEntity<ResponseDto<List<EmployeeDto>>> getListEmployee(HttpServletRequest request) {

		ResponseDto<List<EmployeeDto>> response = new ResponseDto<List<EmployeeDto>>();

		if (StringUtils.isEmpty(request.getHeader(Constants.AUTHORIZATION_HEADER_NAME))) {

		}

		return new ResponseEntity<ResponseDto<List<EmployeeDto>>>(response, HttpStatus.OK);
	}
}
