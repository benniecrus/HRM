package iist.training.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iist.training.hrm.dto.EmployeeDto;
import iist.training.hrm.dto.NewEmployeeDto;
import iist.training.hrm.model.Employee;
import iist.training.hrm.repository.EmployeeRepository;
import iist.training.hrm.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto addEmployee(NewEmployeeDto newEmployee) {
		// TODO Auto-generated method stub
		return null;
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
