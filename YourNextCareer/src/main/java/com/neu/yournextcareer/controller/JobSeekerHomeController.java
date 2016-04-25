package com.neu.yournextcareer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.yournextcareer.pojo.JobSeeker;
import com.neu.yournextcareer.pojo.Resume;

@Controller
public class JobSeekerHomeController {

	
	@RequestMapping(method = RequestMethod.GET, value="/jobSeekerDashboard.htm")
	public String initializeForm(@ModelAttribute("seeker") JobSeeker seeker) {

		return "jobSeekerDashboard";
	}
		
	@RequestMapping(method = RequestMethod.GET, value="/jobSeekerUpdateProfile.htm")
	public String updateProfile() {
		return "jobSeekerUpdateProfile"; // return modal;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="updateBasicProfile.htm")
	public String updateBasicProfileTab() {

		return "jobSeekerUpdateBasicProfile";
	}

	@RequestMapping(method = RequestMethod.GET, value="jobSeekerApplicationStatus.htm")
	public String appStatusTab() {

		return "jobSeekerApplicationStatus";
	}

}
