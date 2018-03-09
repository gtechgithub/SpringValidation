package com.javapoint;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class classz) {
		return Employee.class.isAssignableFrom(classz);
	}
	
	@Override
	public void validate(Object object, Errors errors){
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,  "firstName", "firstname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastname.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
		
	}
}
