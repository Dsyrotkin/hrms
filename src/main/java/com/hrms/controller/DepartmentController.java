package com.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hrms.domain.Department;
import com.hrms.services.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
    
	@GetMapping("/manageDept")
	public String manageDepartment(@ModelAttribute Department dept) {
		
		return "manageDepartment";
	}
	
	public String addDepartment() {
		
		return "deptForm";
	}
	
	public String saveDepartment() {
		
		return "deptForm";
	}
	
	public String deleteDepartment() {
		
		return "manageDept";
	}
	
	
}
