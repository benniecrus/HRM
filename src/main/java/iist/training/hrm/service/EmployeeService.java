package iist.training.hrm.service;

import java.util.List;

import iist.training.hrm.dto.EmployeeDto;
import iist.training.hrm.dto.NewEmployeeDto;

public interface EmployeeService {
	List<EmployeeDto> getListEmployee();
	
	EmployeeDto addEmployee(NewEmployeeDto newEmployee);
}
