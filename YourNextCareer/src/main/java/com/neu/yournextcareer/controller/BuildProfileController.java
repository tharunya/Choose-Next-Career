package com.neu.yournextcareer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.yournextcareer.dao.JobDAO;
import com.neu.yournextcareer.dao.PersonDAO;
import com.neu.yournextcareer.dao.ResumeDAO;
import com.neu.yournextcareer.exception.JobException;
import com.neu.yournextcareer.pojo.JobSeeker;
import com.neu.yournextcareer.pojo.Person;
@Controller
public class BuildProfileController {

	
	@RequestMapping(value="/buildprofilej.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("jobseeker")JobSeeker jobseeker,BindingResult result,Model model,HttpSession session) throws Exception {
	
		try {
			PersonDAO usedao = new PersonDAO();
			Person user1 = usedao.get(jobseeker.getFirstName());

			if(user1 != null){
				model.addAttribute("ud",true);
				return "home";
			}
			JobDAO jd=new JobDAO();
			ResumeDAO resDAO = new ResumeDAO();
			JobSeeker jse = (JobSeeker)session.getAttribute("jbs1");
			resDAO.updateResume(jse.getPersonID(),jobseeker);
			session.setAttribute("jse", jse);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "successPage";
	}

	@RequestMapping(value="/buildprofilej.htm",method = RequestMethod.GET)
	public String initializeForm(Model model,HttpSession session) throws JobException {
		try{Person person = (Person)session.getAttribute("jbs1");
		PersonDAO pd = new PersonDAO();

		Person person1 = pd.get(person.getEmailID());
		model.addAttribute("person",person1);
		}
		catch(Exception e){
			System.out.println("Exception: " + e.getMessage());
		}
		return "buildprofile";
	}

}
