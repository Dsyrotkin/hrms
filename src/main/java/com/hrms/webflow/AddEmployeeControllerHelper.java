package com.hrms.webflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrms.domain.Employee;
import com.hrms.services.EmployeeService;
import com.hrms.services.ImageService;
import com.hrms.services.UserService;

@Component
public class AddEmployeeControllerHelper {

	@Autowired
	UserService userService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ImageService imageService;
	
	public String checkRole() {
		return "admin";
	}
	
	public Employee saveEmployee(Employee employee) {
		imageService.uploadImageFile(employee.getPhoto());
		employeeService.createNewUserFromEmployee(employee);
		return employeeService.save(employee);
	}

}
