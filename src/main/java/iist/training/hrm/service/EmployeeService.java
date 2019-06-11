package iist.training.hrm.service;

import java.text.ParseException;
import java.util.List;

import iist.training.hrm.dto.EmployeeDto;
import iist.training.hrm.dto.NewEmployeeDto;

public interface EmployeeService {
	List<EmployeeDto> getListEmployee();
	
	EmployeeDto addEmployee(NewEmployeeDto newEmployee) throws ParseException;
}
