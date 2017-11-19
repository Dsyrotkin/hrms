package com.hrms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hrms.domain.Department;
import com.hrms.services.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
    
	@GetMapping("/manageDept")
	public String manageDepartment(@ModelAttribute(name="dept") Department dept,Model model) {
		model.addAttribute("depts", departmentService.getAllDepartments());
		
		return "manageDepartment";
	}
	
	@PostMapping("/searchDept")
	public String searchDepartment(@ModelAttribute(name="dept") Department dept,Model model) {
	    
		if(dept.getName().trim().length() == 0) {
			model.addAttribute("depts", departmentService.getAllDepartments());
		}else {
			model.addAttribute("depts", departmentService.getDepartmentsByName(dept.getName()));
		}
		
		return "manageDepartment";
	}
	
	@PostMapping("addNewDept")
	public String addDepartment(@ModelAttribute("newDept") Department department,Model model) {
		
		return "deptForm";
	}
	
	@PostMapping("saveNewDept")
	public String saveDepartment(@Valid @ModelAttribute(name="newDept") Department dept,BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "addNewDept";
		}else {
			departmentService.SaveDepartment(dept);	
			return "redirect:/manageDept";
		}
	}
	
	public String deleteDepartment() {
		
		return "manageDept";
	}
	
	
}
