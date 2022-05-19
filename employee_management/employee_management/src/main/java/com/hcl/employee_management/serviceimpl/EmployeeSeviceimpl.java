package com.hcl.employee_management.serviceimpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.employee_management.domain.Employee;
import com.hcl.employee_management.service.EmployeeService;

@Service
public class EmployeeSeviceimpl implements EmployeeService {
	List <Employee> list = Arrays.asList(
			new Employee(2251L,"ezhil","DDC","software","998893678","ezhil@hcl.com"),
			new Employee(2252L,"arasi","ADC","software","998893678","arasi@hcl.com"),
			new Employee(2253L,"sun","DCC","software","998893678","sun25@hcl.com")
			);

	@Override
	public Employee getEmployee(Long id) {
		
		return list.stream().filter(employee->employee.getId().equals(id)).findAny().orElse(null);
	}

}
