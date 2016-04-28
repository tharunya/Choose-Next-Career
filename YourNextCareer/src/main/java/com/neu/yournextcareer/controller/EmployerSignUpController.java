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
import com.neu.yournextcareer.pojo.Employer;

@Controller
@RequestMapping("/employerSignUp.htm")

public class EmployerSignUpController {
	@Autowired		
	//@Qualifier("seekerValidator")
	EmployerValidator employerValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(employerValidator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("employer") Employer employer, BindingResult result) throws Exception {
		employerValidator.validate(employer, result);
		if (result.hasErrors()) {
			return "employerSignUp";
		}

		PersonDAO personDAO = null;
		try {
			personDAO = new PersonDAO();

			personDAO.create("Employer", employer.getPassword(), employer.getEmailID(), employer.getFirstName(), employer.getLastName(), employer.getConfirmPassword(), employer.getConfirmEmailID());
			// DAO.close(); **/
			return "home";
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return "error";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("employer") Employer employer, BindingResult result) {

		return "employerSignUp";
	}
}
