package iist.training.hrm.service.impl;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iist.training.hrm.dto.AccountDto;
import iist.training.hrm.dto.EmployeeDto;
import iist.training.hrm.dto.request.ChangeEmployeeDto;
import iist.training.hrm.dto.request.NewEmployeeDto;
import iist.training.hrm.exception.ProductException;
import iist.training.hrm.mapping.EmployeeMapping;
import iist.training.hrm.model.Employee;
import iist.training.hrm.model.EmployeeStatus;
import iist.training.hrm.model.Position;
import iist.training.hrm.repository.EmployeeRepository;
import iist.training.hrm.service.AccountService;
import iist.training.hrm.service.EmployeeService;
import iist.training.hrm.service.PositionService;
import iist.training.hrm.utils.DateFormatUtils;

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
		employee.setStatus(EmployeeStatus.WORKING.getStatusCode());

		employee = employeeRepository.saveAndFlush(employee);

		EmployeeDto employeeDto = EmployeeMapping.employeeToEmployeeDto(employee);

		AccountDto accountDto = accountService.generateAccount(employee);

		employeeDto.setAccountDto(accountDto);

		return employeeDto;
	}

	@Override
	public EmployeeDto updateEmployee(NewEmployeeDto updateEmployeeDto) throws ParseException {
		Employee employee = getEmployeeById(updateEmployeeDto.getEmployeeId());

		employee.setLastName(updateEmployeeDto.getLastName());
		employee.setPhoneNumber(updateEmployeeDto.getPhoneNumber());
		employee.setSalary(updateEmployeeDto.getSalary());
		employee.setCountryCode(updateEmployeeDto.getCountryCode());
		employee.setDbo(DateFormatUtils.convertStringToDate(updateEmployeeDto.getDob()));
		employee.setFirstName(updateEmployeeDto.getFirstName());
		employee.setAddress(updateEmployeeDto.getAddress());

		employeeRepository.saveAndFlush(employee);

		return EmployeeMapping.employeeToEmployeeDto(employee);
	}

	@Override
	public EmployeeDto updateEmployeeStatus(ChangeEmployeeDto changeEmployeeStatusDto) {
		Employee employee = getEmployeeById(changeEmployeeStatusDto.getEmployeeId());

		EmployeeStatus employeeStatus = EmployeeStatus
				.getEmployeeStatusByStatusCode(changeEmployeeStatusDto.getStatusId());

		if (employeeStatus == null) {
			throw new ProductException("Cannot find this employee status");
		}

		employee.setStatus(employeeStatus.getStatusCode());
		employeeRepository.saveAndFlush(employee);

		return EmployeeMapping.employeeToEmployeeDto(employee);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
		if (!employeeOptional.isPresent()) {
			throw new ProductException("Cannot find this employee");
		}
		return employeeOptional.get();
	}

	@Override
	public EmployeeDto updateEmployeePosition(ChangeEmployeeDto changeEmployeePositionDto) {
		Employee employee = getEmployeeById(changeEmployeePositionDto.getEmployeeId());

		Position position = positionService.getPositionById(changeEmployeePositionDto.getPositionId());

		employee.setPosition(position);
		employeeRepository.saveAndFlush(employee);

		return EmployeeMapping.employeeToEmployeeDto(employee);
	}

}
