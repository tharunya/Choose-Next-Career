package com.neu.yournextcareer.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.yournextcareer.dao.ApplicationsDAO;
import com.neu.yournextcareer.dao.JobDAO;
import com.neu.yournextcareer.dao.PersonDAO;
import com.neu.yournextcareer.pojo.Applications;
import com.neu.yournextcareer.pojo.Job;
import com.neu.yournextcareer.pojo.Person;

@Controller
public class JobSeekerApplicationForJob {
	@RequestMapping(method = RequestMethod.POST, value="/applyJo/{jobId}")
	public String applyJobs(@PathVariable("jobId") long jobId, HttpSession session){
		Person ps = (Person)session.getAttribute("personSession");

		long personID=ps.getPersonID();

		try {
			ApplicationsDAO appsDAO = new ApplicationsDAO(); 

			Boolean checkResume =appsDAO.checkResume(personID);
			if(!checkResume){
				return "resumeNotFound";
			}
			else{			

				//System.out.println("app DAO"+appsDAO);

				JobDAO jobDAO = new JobDAO(); 
				// System.out.println("Job seeker by job DAO"+jobDAO);
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
			}
		}catch (Exception e) {
			System.out.println("Exception in application: " + e.getMessage());
		}
		return "jobSeekerJobsList";
	}

	@RequestMapping(method = RequestMethod.GET, value="/withdrawApplication/{appId}")
	protected ModelAndView withdrawApplication(@PathVariable("appId") long aid, HttpSession session, HttpServletResponse response) throws Exception {

		Person ps = null;
		//ApplicationsDAO appsDAO = null;
		//JobDAO jobDAO = null;
		PersonDAO personDAO = null;
		List<Applications> appliedJobListInSession = null;

		try {
			ps = (Person)session.getAttribute("personSession");
		//	appliedJobListInSession = new ArrayList<E>();

//			List<Applications> al = (List<Applications>)session.getAttribute("appliedJobList");
			ApplicationsDAO appsDAO = new ApplicationsDAO(); 
			//personDAO = new PersonDAO();
			JobDAO jobDAO = new JobDAO(); 

			System.out.println("App id"+aid);
			/** System.out.println("Job seeker by job DAO"+jobDAO);

			Person jSeeker = (Person)session.getAttribute("personSession");
			Person jobSeeker = (Person) personDAO.lookUpPersonByEmail(jSeeker.getEmailID());
System.out.println("jobSeeker session"+jSeeker);
System.out.println("jobSeeker session"+jobSeeker);**/
/**			Iterator<Applications> appIterator = al.iterator();
			while(appIterator.hasNext()){
				Applications apps = (Applications) appIterator.next();
				System.out.println("App a "+apps.getAppId()+"  also model aid    - "+aid);
				if(apps.getAppId()==aid){
					apps.setApplicationStatus("Withdrawn");
				}
				appliedJobListInSession.add(apps);
			} **/
//			session.setAttribute("appliedJobListInSession",  appliedJobListInSession);
				
			Applications apps = appsDAO.get(aid);

			//Applications apps = (Applications) jobDAO.get(appId);
			appsDAO.changeApplicationStatus("Withdrawn",aid);

			System.out.println("App status"+apps.getApplicationStatus());
			//appsDAO.update(aid);
			//			appsDAO.saveApplication(jobController, jobSeeker);
			System.out.println("App id: "+aid);
			System.out.println("App "+apps);

			session.setAttribute("status", apps);

			System.out.println("Changed status of app with id :"+aid);
		}
		catch(HibernateException he){
			System.out.println("Exception while displaying specificApplication: " + he.getMessage());
		}

		catch(NullPointerException e){
			System.out.println("There was a problem, try again to solve "+e);
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView("jobSeekerApplicationStatus", "appliedJobListInSession", appliedJobListInSession);
		return mv;
	
	}
	/**
	@RequestMapping(method = RequestMethod.GET, value="/applyJob.htm")
	public String initializeForm() {
		return "jobPosted";
	}**/
}