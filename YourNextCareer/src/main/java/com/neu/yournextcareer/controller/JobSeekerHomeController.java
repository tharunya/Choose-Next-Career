package com.neu.yournextcareer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.yournextcareer.pojo.JobSeeker;
import com.neu.yournextcareer.pojo.Person;

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

	@RequestMapping(method = RequestMethod.GET, value="jobSeekerUpdateBasicProfile.htm")
	public String updateBasicProfileTab(@ModelAttribute("profile")Person person, BindingResult result) {

		return "jobSeekerUpdateBasicProfile";
	}

	/**@RequestMapping(method = RequestMethod.GET, value="jobSeekerApplicationStatus.htm")
	public String appStatusTab( HttpSession session) {
		ApplicationsDAO appsDAO = null;
		List appList = null;

		try{
			appsDAO = new ApplicationsDAO();
			System.out.println("Apps dao"+appsDAO);
			appList = new ArrayList<Applications>();
			System.out.println("App list"+appList);

			Person js = (Person)session.getAttribute("personSession");
			System.out.println("Person in app status tab"+js);
			Long pid = js.getPersonID();
			appList = appsDAO.getApplicationsBySpecificJobSeeker(pid);
			System.out.println("Application list for job seeker"+js+"with app list"+appList);
			return "jobSeekerApplicationStatus";
		}
		catch(JobException je){
			System.out.println("Job exceptiong while retrieving applications"+je);
		}
		return "jobSeekerApplicationStatus";
	}**/

}
