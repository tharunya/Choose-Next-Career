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
@RequestMapping("/jobSeekerSignUp.htm")
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
	protected String doSubmitAction(@ModelAttribute("seeker") JobSeeker seeker, BindingResult result) throws Exception {
		jobseekerValidator.validate(seeker, result);
		if (result.hasErrors()) {
			return "jobSeekerSignUp";
		}

		try {
			PersonDAO personDAO = new PersonDAO();
			
			personDAO.create("Job Seeker", seeker.getPassword(), seeker.getEmailID(), seeker.getFirstName(), seeker.getLastName(), seeker.getConfirmPassword(), seeker.getConfirmEmailID());
			// DAO.close(); **/
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "home";
	}

	@RequestMapping( value="/jobSeekerSignUp.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("seeker") JobSeeker seeker, BindingResult result) {

		return "jobSeekerSignUp";
	}

}
