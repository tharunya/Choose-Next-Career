package com.neu.yournextcareer.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.yournextcareer.dao.ApplicationsDAO;
import com.neu.yournextcareer.dao.PersonDAO;
import com.neu.yournextcareer.pojo.Applications;
import com.neu.yournextcareer.pojo.Employer;
import com.neu.yournextcareer.pojo.Person;

import antlr.collections.List;
	
@Controller
public class EmployerHomeController {
	@RequestMapping(method = RequestMethod.GET, value="/employerDashboard.htm")
	public String initializeForm(@ModelAttribute("employer") Employer employer, HttpSession session) {
		
	/**	ArrayList<Applications> appList = new ArrayList<Applications>();
		ApplicationsDAO appListDAO = null;
		try{
//appList = new ArrayList();
appListDAO = new ApplicationsDAO();

appList =	 (List) appListDAO.allAppliedJobs();	
		}catch(HibernateException he){
			System.out.println("Problems with Hibernate, try solving"+he);
		}

		ModelAndView mv = new ModelAndView("employerDashboard", "appLiedJobList", appLiedJobList);
		return mv;	**/
	return "employerDashboard";	
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/employerUpdateProfile.htm")
	public String updateProfile(HttpSession ses,Model m) {
        Person p = (Person) ses.getAttribute("personSession");
        Employer e = (Employer) p;
        
        m.addAttribute("employer", e);
		return "employerUpdateProfile";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/employerUpdateProfile.htm")
	protected String doSubmitAction(@ModelAttribute("employer") Employer employer, BindingResult result,HttpSession ses) throws Exception {

		PersonDAO personDAO = null;
		try {
			personDAO = new PersonDAO();
			personDAO.updateemp(employer,ses);
			// DAO.close(); **/
			return "employerUpdatesuccess";
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		return "error";
	}

}
