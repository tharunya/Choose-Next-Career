package com.neu.yournextcareer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.yournextcareer.dao.JobDAO;
import com.neu.yournextcareer.dao.JobSeekerDAO;
import com.neu.yournextcareer.dao.PersonDAO;
import com.neu.yournextcareer.pojo.Job;
import com.neu.yournextcareer.pojo.Person;

@Controller
public class JobSeekerListJobsController {
	@RequestMapping(value="jobSeekerApplicationStatus.htm", method = RequestMethod.GET)
	protected ModelAndView listAppliedJobs( HttpSession session, HttpServletResponse response) throws Exception {
		JobSeekerDAO jobSeekerDAO = null; 
		List<Job> appliedJobList = null;

		try {
			jobSeekerDAO = new JobSeekerDAO(); 
			System.out.println("Job seeker by job DAO"+jobSeekerDAO);
			PersonDAO personDAO = new PersonDAO();
			System.out.println("Person DAO"+personDAO);

			Person jSeeker = (Person)session.getAttribute("personSession");
			//System.out.println("Job seeker by session"+jSeeker);

			Person jobSeeker = (Person) personDAO.lookUpPersonByEmail(jSeeker.getEmailID());
			//System.out.println("Job seeker by email"+jobSeeker);

			appliedJobList = jobSeekerDAO.appliedJobs(jobSeeker.getPersonID());
			System.out.println("Job controller "+jobSeeker.getPersonID());
			session.setAttribute("appliedJobList", appliedJobList);
			//return "jobPosted";
			//DAO.close();
			//return "jobSeekerApplicationStatus";


		} catch (Exception e) {
			System.out.println("Exception while displaying Job list: " + e.getMessage());
		}

		ModelAndView mv = new ModelAndView("jobSeekerApplicationStatus", "appliedJobList", appliedJobList);
		return mv;
	}


	@RequestMapping(method = RequestMethod.GET, value="/listAllAvailableJobs.htm")
	protected ModelAndView listAllAvailableJobs( HttpSession session, HttpServletResponse response) throws Exception {

		JobDAO jobDAO = null;
		List jobList = null;
		try {
			jobList = new ArrayList<Job>();
			jobDAO = new JobDAO();

			Person js = (Person) session.getAttribute("personSession");
			long pid = js.getPersonID();
			System.out.println("Pid ="+pid);

			jobList = jobDAO.jobsAvailableForSpecificSeeker(pid);

			System.out.println("Job list"+jobList);
			//DAO.close();

		} catch (Exception e) {
			System.out.println("Exception while displaying unapplied jobs list: " + e.getMessage());
		}

		ModelAndView mv = new ModelAndView("jobSeekerJobsList", "jobs", jobList);
		return mv;
	}
}
