package com.hrms.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class EmployeeFullNameValidator implements ConstraintValidator<EmployeeFullName, String> {

	@Override
	public void initialize(EmployeeFullName arg0) {
		
	}

	@Override
	public boolean isValid(String fullName, ConstraintValidatorContext arg1) {
		String[] firstAndLast = fullName.split(" ");
		return firstAndLast.length == 2;
	}

}
