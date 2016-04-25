package com.neu.yournextcareer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.yournextcareer.pojo.Employer;

@Controller
public class EmployerHomeController {

	@RequestMapping(method = RequestMethod.GET, value="/employerDashboard.htm")
	public String initializeForm(@ModelAttribute("employer") Employer employer) {
		return "employerDashboard";
	}
}