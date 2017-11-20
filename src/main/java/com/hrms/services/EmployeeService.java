package com.hrms.services;

import java.util.List;

import com.hrms.domain.Employee;


public interface EmployeeService {

	public Employee save(Employee employee);
	
	public List<Employee> getAll();
	
	public Employee getEmployeeByFullName(String fullName);
	
	public Employee getEmployeeByUserName(String username);
	
	public Employee getEmployeeByEmail(String email);
	
	public Employee createNewUserFromEmployee(Employee employee);
}
