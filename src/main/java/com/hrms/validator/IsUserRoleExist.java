package com.hrms.validator;

import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserRoleValidator.class)
public @interface IsUserRoleExist {

	String message() default "Role.UserRole.exist";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};

}
