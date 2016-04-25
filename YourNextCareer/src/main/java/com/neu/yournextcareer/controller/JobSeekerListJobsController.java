package com.neu.yournextcareer.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.yournextcareer.dao.EmployerDAO;
import com.neu.yournextcareer.pojo.Employer;
import com.neu.yournextcareer.pojo.Job;

@Controller
public class JobSeekerListJobsController {

	@RequestMapping(method = RequestMethod.GET, value="/listAllJobsFromAllEmps.htm")
	protected ModelAndView listAllJobsFromAllEmployers( HttpSession session, HttpServletResponse response) throws Exception {
//		JobDAO jobDAO = null; 
		EmployerDAO employerDAO = null;
	        List employerList = null;
	        List jobList = new ArrayList<Job>();
	        try {
	        	employerDAO = new EmployerDAO(); 	// jobDAO = new JobDAO();

	        //	jobList = jobDAO.list();
	        	employerList = employerDAO.list();
	        	
	            Iterator<Employer> employerIterator = employerList.iterator();

	            while (employerIterator.hasNext())
	            {
	                Employer employer = (Employer) employerIterator.next();

	                Iterator<Job> jobIterator = employer.getJobs().iterator();

	                while (jobIterator.hasNext())
	                {
	                    Job job = (Job) jobIterator.next();
	                    jobList.add(job);
	                    session.setAttribute("jobsList", jobList);      			
	                 }
	        		System.out.println("Jobs list size"+jobList.size());
					System.out.println("Jobs list"+jobList);
	            }
		//DAO.close();

		} catch (Exception e) {
			System.out.println("Exception while displaying Job list: " + e.getMessage());
		}

		ModelAndView mv = new ModelAndView("jobSeekerJobsList", "jobs", jobList);
		return mv;
	}
}