//package com.hrms.exc.exception;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
//import org.springframework.context.support.MessageSourceAccessor;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ControllerAdvice
//public class RestErrorHandler {
//
//	@Autowired
//	private MessageSource messageSource;
//
//	@Autowired
//	private MessageSourceAccessor messageSourceAccessor;
//
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ResponseBody
//	public ValidationErrorDTO processValidationError(MethodArgumentNotValidException ex) {
//		BindingResult result = ex.getBindingResult();
//		List<FieldError> fieldErrors = result.getFieldErrors();
//		return processFieldErrors(fieldErrors);
//	}
//
//	private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
//		ValidationErrorDTO dto = new ValidationErrorDTO("ValidationError");
//
//		for (FieldError fieldError : fieldErrors) {
//			dto.addFieldError(fieldError.getField(), messageSourceAccessor.getMessage(fieldError));
//		}
//		
//		return dto;
//	}
//
//
//}
