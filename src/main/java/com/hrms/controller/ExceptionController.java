package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hrms.exc.exception.DomainError;
import com.hrms.exc.exception.DomainErrors;

@ControllerAdvice
public class ExceptionController {

	@Autowired
	MessageSourceAccessor messageAccessor;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public DomainErrors handleException(MethodArgumentNotValidException exception) {
		// List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		List<ObjectError> fieldErrors = exception.getBindingResult().getAllErrors();
		System.out.println(fieldErrors);
		DomainErrors errors = new DomainErrors();
		errors.setErrorType("ValidationError");
		
		if(fieldErrors.stream().anyMatch(e -> e.getDefaultMessage().toString().equals("may not be empty")))
		{
			DomainError error = new DomainError(messageAccessor.getMessage("Role.form.name.empty"));
			errors.addError(error);
			return errors;
		}
		else if(fieldErrors.stream().anyMatch(e -> e.getDefaultMessage().toString().equals("Role.UserRole.username.should.exist")))
		{
			DomainError error = new DomainError(messageAccessor.getMessage("Role.UserRole.username.should.exist"));
			errors.addError(error);
			return errors;
		}
		
		for (ObjectError fieldError : fieldErrors) {
			String message = fieldError.getDefaultMessage().toString();
			try {				
				DomainError error = new DomainError(messageAccessor.getMessage(message));
				errors.addError(error);
			} catch (NoSuchMessageException ex) {
				errors.addError(new DomainError("Unknown Error ( No such message in message file."));
			}

		}
		return errors;
	}

}
