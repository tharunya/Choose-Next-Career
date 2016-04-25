package com.tharunya.password;

import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.yournextcareer.dao.PasswordDAO;
import com.neu.yournextcareer.dao.PersonDAO;
import com.neu.yournextcareer.exception.PersonNotFoundException;
import com.neu.yournextcareer.pojo.Person;

@Controller
public class PasswordController {
	
/**	PersonDAO personDAO=null;
	
	@RequestMapping(value = "/user/resetPassword", method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse resetPassword(
			HttpServletRequest request, @RequestParam("email") String userEmail) {

		personDAO = new PersonDAO();
		PasswordDAO passwordDAO = new PasswordDAO();
				
		Person person = personDAO.lookUpPersonByEmail(userEmail);
		
		if (person == null) {
			throw new PersonNotFoundException("Person Null");
		}

		String token = UUID.randomUUID().toString();
	
	passwordDAO.createPasswordResetTokenForUser(person, token);
		
	String appUrl = 
	"http://" + request.getServerName() + 
	":" + request.getServerPort() + 
	request.getContextPath();
	SimpleMailMessage email = 
	constructResetTokenEmail(appUrl, request.getLocale(), token, person);
	mailSender.send(email);
	
	return new GenericResponse(
		messages.getMessage("message.resetPasswordEmail", null, request.getLocale()));
	}
	
	@RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
	public String showChangePasswordPage(
	Locale locale, Model model, @RequestParam("id") long id, @RequestParam("token") String token) {
	
	PasswordResetToken passToken = personDAO.getPasswordResetToken(token);
	Person user = passToken.getUser();
	if (passToken == null || user.getPersonID()() != id) {
		String message = messages.getMessage("auth.message.invalidToken", null, locale);
		model.addAttribute("message", message);
		return "redirect:/login.html?lang=" + locale.getLanguage();
		}
	
	Calendar cal = Calendar.getInstance();
	if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
		model.addAttribute("message", messages.getMessage("auth.message.expired", null, locale));
		return "redirect:/login.html?lang=" + locale.getLanguage();
	}

	Authentication auth = new UsernamePasswordAuthenticationToken(
		user, null, userDetailsService.loadUserByUsername(user.getEmailID()).getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
		return "redirect:/updatePassword.html?lang=" + locale.getLanguage();
	}
	
	@RequestMapping(value = "/user/savePassword", method = RequestMethod.POST)
	@PreAuthorize("hasRole('READ_PRIVILEGE')")
	@ResponseBody
	public GenericResponse savePassword(Locale locale, @RequestParam("password") String password) {
		Person person = (Person) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		userService.changeUserPassword(user, password);
	    return new GenericResponse(messages.getMessage("message.resetPasswordSuc", null, locale));
	}
	
	private SimpleMailMessage constructResetTokenEmail(
			String contextPath, Locale locale, String token, Person user) {
			String url = contextPath + "/user/changePassword?id=" + user.getPersonID() + "&token=" + token;
			String message = messages.getMessage("message.resetPassword", null, locale);
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(user.getEmailID());
			email.setSubject("Reset Password");
			email.setText(message + " rn" + url);
			email.setFrom(env.getProperty("support.email"));
			return email;
			}**/
}
