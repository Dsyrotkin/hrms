package com.hrms.validator;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//@Target({ ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RoleNameIsExistValidator.class)
public @interface RoleNameIsExist {

	String message() default "{Role.MSG.NAME_IS_EXIST}";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};

}
