package com.hrms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.hrms.domain.Role;
import com.hrms.domain.User;
import com.hrms.services.RoleService;
import com.hrms.services.UserService;

public class UserShouldExistValidator implements ConstraintValidator<UserShouldExist, String> {

	@Autowired
	private UserService userService;
	
	@Override
	public void initialize(UserShouldExist arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext arg1) {	
		if(userService == null)
		{
			return true;
		}
		User dbRes = userService.getUserByUsername(username);
		return dbRes == null ? false : true;
	}

}

