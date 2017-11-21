package com.hrms.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EmployeeFullNameValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeeFullName {

	String message() default "{Emp.MSG.NOT_FULL_NAME}";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};

}
