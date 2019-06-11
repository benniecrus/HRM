package iist.training.hrm.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iist.training.hrm.dto.EmployeeDto;
import iist.training.hrm.dto.NewEmployeeDto;
import iist.training.hrm.exception.ProductException;
import iist.training.hrm.mapping.EmployeeMapping;
import iist.training.hrm.model.Employee;
import iist.training.hrm.model.Position;
import iist.training.hrm.repository.EmployeeRepository;
import iist.training.hrm.service.EmployeeService;
import iist.training.hrm.service.PositionService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PositionService positionService;
	
	@Override
	public EmployeeDto addEmployee(NewEmployeeDto newEmployee) throws ParseException {
		
		Employee employee = EmployeeMapping.newEmployeeDtoToEmployee(newEmployee);
		Position position = positionService.getPositionById(newEmployee.getPositionId());
		employee.setPosition(position);
		
		employee = employeeRepository.saveAndFlush(employee);
		
		if(employee == null) {
			throw new ProductException("Create employee error");
		}
		
		return EmployeeMapping.employeeToEmployeeDto(employee);
	}
	
	@Override
	public List<EmployeeDto> getListEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean validateEmployee(EmployeeDto employee) {
		return false;
	}
	
}
