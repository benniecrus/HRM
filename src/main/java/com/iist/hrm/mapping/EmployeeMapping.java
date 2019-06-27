package com.iist.hrm.mapping;

import java.text.ParseException;

import com.iist.hrm.dto.EmployeeDto;
import com.iist.hrm.dto.request.NewEmployeeDto;
import com.iist.hrm.model.Employee;
import com.iist.hrm.model.EmployeeStatus;
import com.iist.hrm.utils.DateFormatUtils;

public class EmployeeMapping {
	public static Employee newEmployeeDtoToEmployee(NewEmployeeDto newEmployeeDto) throws ParseException {
		if (newEmployeeDto != null) {
			Employee employee = new Employee();
			employee.setLastName(newEmployeeDto.getLastName());
			employee.setPhoneNumber(newEmployeeDto.getPhoneNumber());
			employee.setIdCardNo(newEmployeeDto.getIdCardNo());
			employee.setCountryCode(newEmployeeDto.getCountryCode());
			employee.setDbo(DateFormatUtils.convertStringToDate(newEmployeeDto.getDob()));
			employee.setFirstName(newEmployeeDto.getFirstName());
			employee.setAddress(newEmployeeDto.getAddress());
			employee.setEmail(newEmployeeDto.getEmail());
			return employee;
		}

		return null;
	}

	public static EmployeeDto employeeToEmployeeDto(Employee employee) {
		if (employee != null) {
			EmployeeDto employeeDto = new EmployeeDto();
			employeeDto.setAddress(employee.getAddress());
			employeeDto.setCountryCode(employee.getCountryCode());
			employeeDto.setDob(employee.getDbo());
			employeeDto.setFirstName(employee.getFirstName());
			employeeDto.setLastName(employee.getLastName());
			employeeDto.setPhoneNumber(employee.getPhoneNumber());
			employeeDto.setIdCardNo(employee.getIdCardNo());
			employeeDto.setStatus(EmployeeStatus.getEmployeeStatusByStatusCode(employee.getStatus()));
			employeeDto.setPosition(PositionMapping.positionMapping(employee.getPosition()));
			employeeDto.setEmail(employee.getEmail());
			return employeeDto;
		}

		return null;
	}

}
