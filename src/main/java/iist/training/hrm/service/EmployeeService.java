package iist.training.hrm.service;

import java.text.ParseException;

import iist.training.hrm.dto.EmployeeDto;
import iist.training.hrm.dto.request.ChangeEmployeeDto;
import iist.training.hrm.dto.request.NewEmployeeDto;
import iist.training.hrm.model.Employee;

public interface EmployeeService {
	EmployeeDto addEmployee(NewEmployeeDto newEmployee) throws ParseException;
	EmployeeDto updateEmployee(NewEmployeeDto updateEmployeeDto) throws ParseException;
	EmployeeDto updateEmployeeStatus(ChangeEmployeeDto changeEmployeeStatusDto);
	EmployeeDto updateEmployeePosition(ChangeEmployeeDto changeEmployeePositionDto);
	Employee getEmployeeById(int employeeId);
}
