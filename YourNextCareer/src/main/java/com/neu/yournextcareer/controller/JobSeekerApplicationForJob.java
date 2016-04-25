package com.neu.yournextcareer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.yournextcareer.dao.ApplicationsDAO;
import com.neu.yournextcareer.dao.JobDAO;
import com.neu.yournextcareer.dao.JobSeekerDAO;
import com.neu.yournextcareer.dao.PersonDAO;
import com.neu.yournextcareer.pojo.Job;
import com.neu.yournextcareer.pojo.JobSeeker;
import com.neu.yournextcareer.pojo.Person;

@Controller
public class JobSeekerApplicationForJob {

	@RequestMapping(method = RequestMethod.GET, value="/applyJob/{jobId}")
	public String applyJobs(@PathVariable("jobId") String jobId, HttpSession session){

		try {
			ApplicationsDAO appsDAO = new ApplicationsDAO(); 
			System.out.println("app DAO"+appsDAO);
			JobDAO jobDAO = new JobDAO(); 
			System.out.println("Job seeker by job DAO"+jobDAO);
			PersonDAO personDAO = new PersonDAO();
			System.out.println("Person DAO"+personDAO);
			Person jSeeker = (Person)session.getAttribute("personSession");
			System.out.println("Job seeker by session"+jSeeker);
			Person jobSeeker = (Person) personDAO.lookUpPersonByEmail(jSeeker.getEmailID());
			System.out.println("Job seeker by email"+jobSeeker);
					Job jobController = (Job) jobDAO.get(jobId);
		System.out.println("Job controller "+jobSeeker.getPersonID());
			appsDAO.saveApplication(jobController, jobSeeker);

		System.out.println("applied"+appsDAO+"Job seeker"+jobSeeker+"Job "+jobController);

		}catch (Exception e) {
			System.out.println("Exception in application: " + e.getMessage());
		}
		return "jobPosted";
	}


	@RequestMapping(method = RequestMethod.GET, value="/applyJob.htm")
	public String initializeForm() {
		return "jobPosted";
	}

}
