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
	public String manageDepartment(Model model) {
		model.addAttribute("dept", new Department());
		model.addAttribute("depts", departmentService.getAllDepartments());
		
		return "dept/manageDepartment";
	}
	
	@PostMapping("/searchDept")
	public String searchDepartment(@ModelAttribute(name="dept") Department dept,Model model) {
	    
		if(dept.getName().trim().length() == 0) {
			model.addAttribute("depts", departmentService.getAllDepartments());
		}else {
			model.addAttribute("depts", departmentService.getDepartmentsByName(dept.getName()));
		}
		
		return "dept/manageDepartment";
	}
	
	@PostMapping("addNewDept")
	public String addDepartment(Model model) {
		model.addAttribute("newDept", new Department());

		return "dept/addDepartment";
	}
	
	@PostMapping("saveNewDept")
	public String saveDepartment(@Valid @ModelAttribute(name="newDept") Department dept,BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "dept/addDepartment";
		}else {
			departmentService.SaveDepartment(dept);	
			dept.setDescription("Mohammad Weshah");
			departmentService.SaveDepartment(dept);
			
			return "redirect:/manageDept";
		}
	}
	
	public String deleteDepartment() {
		
		return "manageDept";
	}
	
	
}
