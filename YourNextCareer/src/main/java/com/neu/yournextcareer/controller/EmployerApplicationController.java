package com.neu.yournextcareer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.yournextcareer.pojo.Application;

@Controller
@RequestMapping(value="/employerApplicationList.htm")
public class EmployerApplicationController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("application") Application application, BindingResult result) {

		return "employerApplicationList";
	}
}
