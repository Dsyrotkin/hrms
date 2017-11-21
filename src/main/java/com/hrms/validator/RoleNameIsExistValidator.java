package com.hrms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import com.hrms.domain.Role;
import com.hrms.services.RoleService;

public class RoleNameIsExistValidator implements ConstraintValidator<RoleNameIsExist, String> {

	@Autowired
	private RoleService roleService;
	
	@Override
	public void initialize(RoleNameIsExist arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String roleName, ConstraintValidatorContext arg1) {	
		if(roleService == null)
		{
			return true;
		}
		Role dbRes = roleService.getByName(roleName);
		return dbRes == null ? true : false;
	}

}
