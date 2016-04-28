package com.neu.yournextcareer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.yournextcareer.dao.JobDAO;
import com.neu.yournextcareer.dao.PersonDAO;
import com.neu.yournextcareer.pojo.Employer;
import com.neu.yournextcareer.pojo.Job;

@Controller
public class EmployerJobPost {
	@RequestMapping(method = RequestMethod.POST, value="/employerJobPost.htm")
	protected String doSubmitAction(@ModelAttribute("job") Job job, HttpSession session) throws Exception {
		/*jobValidator.validate(seeker, result);
		if (result.hasErrors()) {
			return "employerJobPost";
		}*/

		try {
			JobDAO jobDAO = new JobDAO();
			PersonDAO personDAO = new PersonDAO();
			
			
			Employer person = (Employer) session.getAttribute("personSession");
		System.out.println("Emp - person session"+person.getEmailID());
			jobDAO.create(job.getJobTitle(), job.getJobType(), 
					job.getJobCategory(), job.getJobDescription(), 
					job.getJobRequirement(), job.getJobResponsibilities(), 
					job.getJobLocation(), job.getJobCompany(), job.getJobPostedDate());
					//job.getJobStatus(), job.getJobPostedDate(), job.getJobAppliedDate(), job.getJobStatusChangedDate());

			Employer employer = (Employer)personDAO.lookUpPersonByEmail(person.getEmailID());

			employer.addJobs(job);
		System.out.println("emp jobs"+employer.getJobs());
		job.setEmployer(employer);	
		
		jobDAO.save(job);
			
			// DAO.close(); **/
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "jobposted"; // return modal
	}

	@RequestMapping(method = RequestMethod.GET, value="/employerJobPost.htm")
	public String initializeForm(@ModelAttribute("job") Job job) {

		return "employerJobPost";
	}

}
