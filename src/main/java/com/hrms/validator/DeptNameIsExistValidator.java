package com.hrms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hrms.domain.Department;
import com.hrms.services.DepartmentService;

@Component
public class DeptNameIsExistValidator implements ConstraintValidator<DeptNameIsExist, Department> {

	@Autowired
	private DepartmentService departmentService;

	@Override
	public void initialize(DeptNameIsExist arg0) {
		
	}

	@Override
	public boolean isValid(Department department, ConstraintValidatorContext context) {
		if(departmentService == null) {
			return true;
		}
		
		Department product = null;
		
		if(department.getId() == 0) {
			product = departmentService.getByName(department.getName());
		}else {
			product = departmentService.getByIdAndName(department.getId(), department.getName());
		}

		return product == null ? true : false;
	}

}
