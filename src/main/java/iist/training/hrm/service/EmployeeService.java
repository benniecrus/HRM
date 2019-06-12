package iist.training.hrm.service;

import java.text.ParseException;

import iist.training.hrm.dto.EmployeeDto;
import iist.training.hrm.dto.NewEmployeeDto;

public interface EmployeeService {
	EmployeeDto addEmployee(NewEmployeeDto newEmployee) throws ParseException;
}
