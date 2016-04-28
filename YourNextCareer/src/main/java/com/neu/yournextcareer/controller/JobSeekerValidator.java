package com.neu.yournextcareer.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.yournextcareer.pojo.JobSeeker;

@Component
public class JobSeekerValidator implements Validator {

	@Override
	public boolean supports(Class seeker) {
		// TODO Auto-generated method stub
		return seeker.equals(JobSeeker.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {

JobSeeker seeker = (JobSeeker) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstname.required", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName.required", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.password.required", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailID", "error.emailID.required", "Email ID is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "error.confirmPassword.required", "Confirm password is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmEmailID", "error.confirmEmailID.required", "Password is Required");
		
		if(!seeker.getPassword().equals(seeker.getConfirmPassword())){
            errors.rejectValue("error.password.nomatch", "Passwords must match");
        }
		if(!seeker.getEmailID().equals(seeker.getConfirmEmailID())){
            errors.rejectValue("error.emailid.nomatch", "Enter the same email id in both fields");
        } 
	}

}
