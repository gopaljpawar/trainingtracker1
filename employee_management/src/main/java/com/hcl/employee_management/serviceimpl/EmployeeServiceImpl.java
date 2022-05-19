package com.hcl.employee_management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee_management.domain.Employee;
import com.hcl.employee_management.exception.EmployeeNotFoundException;
import com.hcl.employee_management.repository.EmployeeRepository;
import com.hcl.employee_management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeBySsn(Long ssn) {
		Optional<Employee>employee = employeeRepository.findBySsn(ssn);
		if(employee.isPresent()) {
			return employee.get();
			}else {
			throw new EmployeeNotFoundException("Employee not found with id :" +ssn);
			}
			
	}

	@Override
	public void deleteEmployeeBySsn(Long ssn) {
		Employee employeedb = employeeRepository.findBySsn(ssn).get();
		employeeRepository.delete(employeedb);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return  employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Optional<Employee> employee2 = employeeRepository.findById(employee.getId());
		if (employee2.isPresent()) {
		Employee updatedEmployee = employee2.get();
		updatedEmployee.setId(employee.getId());
		updatedEmployee. setSsn(employee.getSsn());
		updatedEmployee.setEmployeeName(employee.getEmployeeName());
		updatedEmployee.setDepartment(employee.getDepartment());
		updatedEmployee.setDesignation(employee.getDesignation());
		updatedEmployee.setPhonenumber(employee.getPhonenumber());
		updatedEmployee.setEmail(employee.getEmail());
		
		return employeeRepository.save(updatedEmployee);
		} else {
		throw new EmployeeNotFoundException("Employee not found with id : " + employee.getSsn()
		);
		}
	}
	
	
}
