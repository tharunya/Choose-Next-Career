package com.neu.yournextcareer.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.yournextcareer.dao.JobDAO;
import com.neu.yournextcareer.dao.PersonDAO;
import com.neu.yournextcareer.pojo.Employer;
import com.neu.yournextcareer.pojo.Job;
import com.neu.yournextcareer.pojo.Person;

@Controller
public class EmployerJobPost {

	@RequestMapping(method = RequestMethod.POST, value="/jobPosted.htm")
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
					job.getJobLocation(), job.getJobCompany());

			Employer employer = (Employer)personDAO.lookUpPersonByEmail(person.getEmailID());

			employer.addJobs(job);
		System.out.println("emp jobs"+employer.getJobs());
		job.setEmployer(employer);	
		
		jobDAO.save(job);
			
			// DAO.close(); **/
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "jobPosted"; // return modal
	}

	@RequestMapping(method = RequestMethod.GET, value="/employerJobPost.htm")
	public String initializeForm(@ModelAttribute("job") Job job) {

		return "employerJobPost";
	}
}
