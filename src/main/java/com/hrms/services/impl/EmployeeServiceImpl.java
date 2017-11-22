package com.hrms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.domain.Employee;
import com.hrms.domain.Project;
import com.hrms.domain.Role;
import com.hrms.domain.User;
import com.hrms.repositories.EmployeeRepository;
import com.hrms.services.EmployeeService;
import com.hrms.services.RoleService;
import com.hrms.services.UserService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	RoleService roleService;

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAll() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeByFullName(String fullName) {
		return employeeRepository.findByFullName(fullName);
	}

	@Override
	public Employee getEmployeeByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee createNewUserFromEmployee(Employee employee) {
		String[] fullName = employee.getFullName().split(" ");
		String username = fullName[0].charAt(0) + fullName[1];
		User newUser = userService.createUser(username.toLowerCase());
		Role role = roleService.getByName("ROLE_USER");
		newUser.addRole(role);
		newUser.setEmployee(employee);
		employee.setUser(newUser);
		return employee;
	}

	@Override
	public Employee getById(Long id) {
		return employeeRepository.findOne(id);
	}
	
}
