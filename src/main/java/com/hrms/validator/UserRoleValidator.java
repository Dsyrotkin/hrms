package com.hrms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.hrms.domain.Role;
import com.hrms.domain.User;
import com.hrms.domain.rest.AddUserRole;
import com.hrms.services.RoleService;
import com.hrms.services.UserService;

public class UserRoleValidator implements ConstraintValidator<IsUserRoleExist, AddUserRole> {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Override
	public void initialize(IsUserRoleExist arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(AddUserRole userRole, ConstraintValidatorContext arg1) {
		if (userService == null || roleService == null) {
			return true;
		}
		
		Role role = roleService.getByName(userRole.getRoleName());
		User user = userService.getUserByUsername(userRole.getUsername());
		
		if(user == null || role == null)
		{
			return false;
		}
		
		if (user.getRoles().stream().anyMatch(r -> userRole.getRoleName().equals(r.getName()))) {
			return false;
		}

		return true;
	}

}
