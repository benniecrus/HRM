package iist.training.hrm.service.impl;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iist.training.hrm.dto.AccountDto;
import iist.training.hrm.dto.EmployeeDto;
import iist.training.hrm.dto.NewEmployeeDto;
import iist.training.hrm.exception.ProductException;
import iist.training.hrm.mapping.EmployeeMapping;
import iist.training.hrm.model.Employee;
import iist.training.hrm.model.Position;
import iist.training.hrm.repository.EmployeeRepository;
import iist.training.hrm.service.AccountService;
import iist.training.hrm.service.EmployeeService;
import iist.training.hrm.service.PositionService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AccountService accountService;
	
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
		
		EmployeeDto employeeDto = EmployeeMapping.employeeToEmployeeDto(employee);
		
		AccountDto accountDto = accountService.generateAccount(employee);
		
		employeeDto.setAccountDto(accountDto);
		
		return employeeDto;
	}
	
}
