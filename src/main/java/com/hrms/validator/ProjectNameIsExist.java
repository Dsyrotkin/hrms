package com.hrms.validator;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//@Target({ ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Target(TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProjectNameIsExistValidator.class)
public @interface ProjectNameIsExist {

	String message() default "{Project.MSG.NAME_IS_EXIST}";

	Class<?>[] groups() default {};

	public abstract Class<? extends Payload>[] payload() default {};

}
