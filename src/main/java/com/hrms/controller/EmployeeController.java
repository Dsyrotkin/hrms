package com.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hrms.domain.Employee;
import com.hrms.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
		
}
