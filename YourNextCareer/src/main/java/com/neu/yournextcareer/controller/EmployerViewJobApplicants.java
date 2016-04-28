package com.neu.yournextcareer.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.yournextcareer.dao.ApplicationsDAO;
import com.neu.yournextcareer.dao.JobDAO;
import com.neu.yournextcareer.dao.PersonDAO;
import com.neu.yournextcareer.pojo.Applications;
import com.neu.yournextcareer.pojo.Employer;
import com.neu.yournextcareer.pojo.Job;
import com.neu.yournextcareer.pojo.Person;

@Controller
public class EmployerViewJobApplicants {
	@RequestMapping(method = RequestMethod.GET, value="/employerViewApplications/{jobID}")
	protected ModelAndView viewAllApplicantsForJob(@PathVariable("jobID") Long jobID, HttpSession session) throws Exception {

		JobDAO jobDAO = null;
		List<Applications> applicationList = new ArrayList();
		System.out.println("List outside try "+applicationList);

		try{
			jobDAO = new JobDAO();
			applicationList = jobDAO.getApplications(jobID);
			System.out.println("Job id: "+jobID);
			session.setAttribute("applicationList", applicationList);
			System.out.println("Applied to :"+applicationList);
		}
		catch(HibernateException he){
			System.out.println("Exception while displaying Application list: " + he.getMessage());
		}

		ModelAndView mv = new ModelAndView("employerViewApplications", "apps", applicationList);
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value="/employerJobApplicantsList.htm")
	public String listAllJobsPostedByEmployer(HttpSession session) {

		PersonDAO personDAO = null; 
		//		ApplicationsDAO appsDAO = null;
		//	List applicationList = new ArrayList<Applications>();
		List jobList = new ArrayList<Job>();

		try{
			personDAO = new PersonDAO();
			//	appsDAO = new ApplicationsDAO();

			Person employer = (Person)session.getAttribute("personSession");
			System.out.println( "Emp in controller of employer job app list"+employer);

			Person currentEmployer = (Person)personDAO.lookUpPersonByEmail(employer.getEmailID());
			//applicationList = appsDAO.listByApplicationStatus("Applied");
			//jobList = employerDAO.listJobsByEmployer(employer.getPersonID());
			Employer e = (Employer) currentEmployer;
			Iterator<Job> jobIterator = e.getJobs().iterator();

			while (jobIterator.hasNext())
			{
				Job job = (Job) jobIterator.next();
				jobList.add(job);
			}
			session.setAttribute("jobsList", jobList);
			System.out.println("JobList"+jobList);
		}
		catch(HibernateException he){
			System.out.println("Exception while displaying Application list: " + he.getMessage());
		}

		/**ModelAndView mv = new ModelAndView("applicationsList", "apps", applicationList);
		return mv;**/
		return "employerJobApplicantsList";
	}

	@RequestMapping(value="/changeStatus/{appId}")
	protected String displaySpecificApplicant(@PathVariable("appId") Long appId, HttpSession session) throws Exception {

		JobDAO jobDAO = null;
		ApplicationsDAO appsDAO = null;
		Applications app = null;
		try{

			app = new Applications();
			appsDAO = new ApplicationsDAO();
			System.out.println("App dao"+appsDAO);
			//	jobDAO = new JobDAO();
			System.out.println("After job dao in display spec app");
			app = appsDAO.get(appId);
			System.out.println("App id: "+appId);
			System.out.println("App "+app);

			session.setAttribute("status", app);
			
			System.out.println("Applied to :"+appId);
		}
		catch(HibernateException he){
			System.out.println("Exception while displaying specificApplication: " + he.getMessage());
		}

		//	ModelAndView mv = new ModelAndView("jobPosted", "status", app);
		//	return mv;
		return "employerStatusChange";
	}	

	@RequestMapping(value="/changedStatus/{appId}", method = RequestMethod.POST)
	protected String changeStatus(@RequestParam("status")String status, @PathVariable("appId")Long appId) {
		try{
			JobDAO jobDAO = new JobDAO();

			jobDAO.changeStatus(status,appId);
		}catch(Exception e){
			System.out.println("Exception in changing status"+e);
		}
		return "employerStatusChange";
	}
}
