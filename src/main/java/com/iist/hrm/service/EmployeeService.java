package com.iist.hrm.service;

import java.text.ParseException;
import java.util.List;

import com.iist.hrm.dto.EmployeeDto;
import com.iist.hrm.dto.request.ChangeEmployeeDto;
import com.iist.hrm.dto.request.NewEmployeeDto;
import com.iist.hrm.model.Employee;

public interface EmployeeService {
	EmployeeDto addEmployee(NewEmployeeDto newEmployee) throws ParseException;
	EmployeeDto updateEmployee(NewEmployeeDto updateEmployeeDto) throws ParseException;
	EmployeeDto updateEmployeeStatus(ChangeEmployeeDto changeEmployeeStatusDto);
	EmployeeDto updateEmployeePosition(ChangeEmployeeDto changeEmployeePositionDto);
	Employee getEmployeeById(int employeeId);
	List<EmployeeDto> searchEmployee(String searchString);
	List<EmployeeDto> searchEmployeeByPosition(int positionId);
	EmployeeDto searchEmployeeByUserName(String username);
	List<EmployeeDto> getAllEmployee();
}
