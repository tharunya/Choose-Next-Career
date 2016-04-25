package com.neu.yournextcareer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class EmployerSignUpController {
	@Autowired		
	@Qualifier("employerValidator")
	EmployerValidator employerValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(employerValidator);
	}

	@RequestMapping(method = RequestMethod.POST, value="/employerSignUp.htm")
	protected String doSubmitAction(@ModelAttribute("employer") Employer employer, BindingResult result) throws Exception {
		employerValidator.validate(employer, result);
		if (result.hasErrors()) {
			return "employerSignUp";
		}

		try {
			PersonDAO personDAO = new PersonDAO();
			
			personDAO.create("Employer", employer.getPassword(), employer.getEmailID(), employer.getFirstName(), employer.getLastName(), employer.getConfirmPassword(), employer.getConfirmEmailID());
			// DAO.close(); **/
		} catch (Exception e) {
			System.out.println(e+"Handled exception:");
		}

		return "home";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("employer") Employer employer, BindingResult result) {

		return "employerSignUp";
	}
}
