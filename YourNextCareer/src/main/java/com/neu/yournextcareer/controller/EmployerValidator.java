package com.neu.yournextcareer.controller;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.yournextcareer.pojo.Employer;

@Component
public class EmployerValidator implements Validator{

	@Override
	public boolean supports(Class employer) {
		// TODO Auto-generated method stub
		return employer.equals(Employer.class);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {

		Employer employer = (Employer) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstname.required", "First Name ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName.required", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password.required", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailID", "error.emailID.required", "Email ID is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.confirmPassword.required", "Confirming password is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmEmailID", "error.confirmEmailID.required", "Confirming email ID is Required");
		
	/**	if(!employer.getPassword().equals(employer.getConfirmPassword())){
            errors.rejectValue("error.password.nomatch", "Passwords must match");
        }
		if(!employer.getEmailID().equals(employer.getConfirmEmailID())){
            errors.rejectValue("error.emailid.nomatch", "Enter the same email id in both fields");
        }**/ 
		
	}	
}