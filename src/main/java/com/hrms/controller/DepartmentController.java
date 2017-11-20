package com.hrms.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hrms.domain.Department;
import com.hrms.exc.exception.OperationResult;
import com.hrms.exc.exception.ValidationErrorDTO;
import com.hrms.services.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	
//	@Autowired
//	private MessageSourceAccessor messageSourceAccessor;

	@GetMapping("/manageDept")
	public String manageDepartment(Model model) {
		model.addAttribute("dept", new Department());
		model.addAttribute("depts", departmentService.getAllDepartments());

		return "manageDepartment";
	}

	@PostMapping("/searchDept")
	public String searchDepartment(@ModelAttribute(name = "dept") Department dept, Model model) {

		if (dept.getName().trim().length() == 0) {
			model.addAttribute("depts", departmentService.getAllDepartments());
		} else {
			model.addAttribute("depts", departmentService.getDepartmentsByName(dept.getName()));
		}

		return "manageDepartment";
	}

	@RequestMapping("addNewDept")
	public String addDepartment(Model model) {
		model.addAttribute("newDept", new Department());

		return "addDepartment";
	}

	@PostMapping("saveNewDept")
	public String saveNewDepartment(@Valid @ModelAttribute(name = "newDept") Department dept,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "addDepartment";
		} else {
			departmentService.SaveDepartment(dept);

			return "redirect:/manageDept";
		}
	}

	@GetMapping("updateDept")
	public String updateDepartment(@RequestParam("id") long id, Model model) {
		model.addAttribute("updateDept", departmentService.getDepartment(id));

		return "updateDepartment";
	}

	@PostMapping("saveUpdateDept")
	public String saveUpdateDepartment(@Valid @ModelAttribute(name = "updateDept") Department dept,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "updateDepartment";
		} else {
			departmentService.SaveDepartment(dept);

			return "redirect:/manageDept";
		}
	}

	@RequestMapping(value="deleteDep/{id}",method=RequestMethod.POST,produces="application/json")
	public @ResponseBody OperationResult  deleteDepartment(@PathVariable(name="id") long id) {
		departmentService.deleteDepartment(id);
		
		OperationResult operationResult = new OperationResult();
		operationResult.setMessage("The Department has been deleted successfully ");
		operationResult.setSuccces(true);
		
		return operationResult;
	}
	
	@GetMapping("viewDept")
	public String viewDepartment(@RequestParam("id") long id, Model model) {
		model.addAttribute("viewDept", departmentService.getDepartment(id));

		return "viewDepartment";
	}
	

	@ExceptionHandler(SQLException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public OperationResult processValidationError(SQLException ex) {
		OperationResult operationResult = new OperationResult();
		operationResult.setSuccces(false);
		operationResult.setMessage(ex.getMessage());
        
		return operationResult;
	}
	


}


