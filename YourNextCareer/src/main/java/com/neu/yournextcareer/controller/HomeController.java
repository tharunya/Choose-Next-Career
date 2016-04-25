package com.neu.yournextcareer.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.yournextcareer.pojo.JobSeeker;
import com.neu.yournextcareer.pojo.Person;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/jobPosted.htm", method = RequestMethod.GET)
	public String successPage() {

		return "jobPosted";
	}
	
	@RequestMapping(value = "/forgotPassword.htm", method = RequestMethod.GET)
	public String forgotPasswordPage(@ModelAttribute("reset")Person person) {

		return "forgotPassword";
	}
	
}