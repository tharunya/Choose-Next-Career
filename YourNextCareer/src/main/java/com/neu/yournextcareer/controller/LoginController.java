package com.neu.yournextcareer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.yournextcareer.dao.PersonDAO;
import com.neu.yournextcareer.pojo.Person;

@Controller
@RequestMapping("/loggedin.htm")
public class LoginController {

	@RequestMapping(method = RequestMethod.POST, value="/loggedin.htm")
	protected String doSubmitAction(@ModelAttribute("person") Person person, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		/**
		 * loginValidator.validate(person, result); if (result.hasErrors()) {
		 * return "home"; }
		 **/

		try {
			//.out.println("Person DAO inside: "+personDAO);
			PersonDAO personDAO = new PersonDAO();
			System.out.println("Person Dao"+personDAO);
			Person personLookedUp = personDAO.lookUpPersonByEmailAndPassword(person.getEmailID(),person.getPassword());

			System.out.println("Person Looked up"+personLookedUp.getEmailID());
			if(personLookedUp!=null){
				System.out.println("Person acquired"+person);
				HttpSession session = request.getSession();	
				System.out.println("Session"+session);
				session.setAttribute("personSession", personLookedUp);
				if (personLookedUp.getRole().equalsIgnoreCase("Job Seeker")) {
					System.out.println("Print JS"+personLookedUp.getRole());
					return "jobSeekerLoggedIn";
				} else if (personLookedUp.getRole().equalsIgnoreCase("Employer")) {
					//session.setAttribute("employerCompany", company);
					return "employerLoggedIn";
				} 
			}
			else if(personLookedUp==null){
				model.addAttribute("error",true);
				return "home";	
				}
		} catch (Exception e) {
			System.out.println("Problems in login: " + e.getMessage());
			model.addAttribute("error",true);
			return "home";
		}
		//returnPage = "home"
		return null;
	}

	@RequestMapping(value="/logout.htm",method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response){
	/**	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		    return "redirect:/home?logout";**/
		
	return "successPage";
	}
	/**
	 * public String initializeForm(@ModelAttribute("person") Person person,
	 * BindingResult result) {
	 * 
	 * return ""; }
	 **/
}
