package iist.training.hrm.service;

import java.text.ParseException;
import java.util.List;

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
	List<EmployeeDto> searchEmployee(String searchString);
	List<EmployeeDto> searchEmployeeByPosition(int positionId);
	EmployeeDto searchEmployeeByUserName(String username);
}
