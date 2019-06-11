package iist.training.hrm.mapping;

import java.text.ParseException;

import iist.training.hrm.dto.EmployeeDto;
import iist.training.hrm.dto.NewEmployeeDto;
import iist.training.hrm.model.Employee;
import iist.training.hrm.utils.DateFormatUtils;

public class EmployeeMapping {
	public static Employee newEmployeeDtoToEmployee(NewEmployeeDto newEmployeeDto) throws ParseException {
		Employee employee = new Employee();
		employee.setLastName(newEmployeeDto.getLastName());
		employee.setPhoneNumber(newEmployeeDto.getPhoneNumber());
		employee.setSalary(newEmployeeDto.getSalary());
		employee.setCountryCode(newEmployeeDto.getCountryCode());
		employee.setDbo(DateFormatUtils.convertStringToDate(newEmployeeDto.getDob()));
		employee.setFirstName(newEmployeeDto.getFirstName());
		
		return employee;
	}
	
	public static EmployeeDto employeeToEmployeeDto(Employee employee) {
		
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setAddress(employee.getAddress());
		employeeDto.setCountryCode(employee.getCountryCode());
		employeeDto.setDob(employee.getDbo());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setPhoneNumber(employee.getPhoneNumber());
		employeeDto.setSalary(employee.getSalary());
		
		return employeeDto;
	}
	
}
