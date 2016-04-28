package com.neu.yournextcareer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.yournextcareer.dao.PersonDAO;
import com.neu.yournextcareer.pojo.JobSeeker;

@Controller
public class JobSeekerSignUpController {
	
	@Autowired		
	//@Qualifier("seekerValidator")
	JobSeekerValidator jobseekerValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(jobseekerValidator);
	}

	@RequestMapping(method = RequestMethod.POST, value="/jobSeekerSignUp.htm")
	public String doSubmitAction(@ModelAttribute("seeker") JobSeeker seeker, BindingResult result) throws Exception {
		jobseekerValidator.validate(seeker, result);
		if (result.hasErrors()) {
			return "jobSeekerSignUp";
		}
		PersonDAO personDAO =null;
		try {
			personDAO = new PersonDAO();
			
			personDAO.create("Job Seeker", seeker.getPassword(), seeker.getEmailID(), seeker.getFirstName(), seeker.getLastName(), seeker.getConfirmPassword(), seeker.getConfirmEmailID());
			// DAO.close(); **/
			System.out.println("person DAo job seeker sign up"+seeker.getEmailID());
			
			return "successPage";
		} 
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		System.out.println("outside catch");
		return "error";
	}

	@RequestMapping(method = RequestMethod.GET, value="jobSeekerSignUp.htm")
	public String initializeForm(@ModelAttribute("seeker") JobSeeker seeker, BindingResult result) {

		return "jobSeekerSignUp";
	}

}
