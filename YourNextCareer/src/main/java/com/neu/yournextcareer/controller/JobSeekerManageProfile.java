package com.neu.yournextcareer.controller;

import java.io.IOException;
import java.sql.Blob;

import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neu.yournextcareer.dao.JobSeekerDAO;
import com.neu.yournextcareer.dao.PersonDAO;
import com.neu.yournextcareer.dao.ResumeDAO;
import com.neu.yournextcareer.exception.JobException;
import com.neu.yournextcareer.pojo.Employer;
import com.neu.yournextcareer.pojo.JobSeeker;
import com.neu.yournextcareer.pojo.Person;
import com.neu.yournextcareer.pojo.Resume;

@Controller
public class JobSeekerManageProfile {
	/**public String initializeForm() {
		return "jobSeekerUpdateProfile"; // return modal;
	}**/
	
	@RequestMapping(value = "/uploadResume.htm", method = RequestMethod.POST)
    public String doSubmitAction(@ModelAttribute("resume") Resume resume, @RequestParam("resumefile") CommonsMultipartFile resumefile, HttpSession session, Model model) throws IOException {
try {			
			PersonDAO personDAO = new PersonDAO();
			ResumeDAO resumeDao = new ResumeDAO();
			
			Blob blob = (Blob) Hibernate.createBlob(resumefile.getInputStream());
			//Blob blob = (Blob) Hibernate.createBlob(photo.getInputStream());
			String resumecontent = resumefile.getContentType();
			String resumeName = resumefile.getOriginalFilename();
			resume.setContent(blob);
			resume.setResumeFileType(resumecontent);
			resume.setResumeFileName(resumeName);
			
			resumeDao.create(resume.getResumeTitle(),resume.getContent(),resume.getResumeFileType(),resume.getResumeFileName());
			
			Person js = (Person) session.getAttribute("personSession");
			System.out.println("getting js");
			  String jobSeekerEmail = js.getEmailID();
			  
			  JobSeeker js1 = (JobSeeker) personDAO.lookUpPersonByEmail(jobSeekerEmail);
			  js1.setResume(resume);
			  
			  resumeDao.save(resume);
			//  jobDao.save(job);  
			return "jobPosted";
		}
		catch (JobException c){
			System.out.println("executed catch");
			model.addAttribute("error",true);
			//return "empreg";
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
e.printStackTrace();
			
		}
		
		return "";
	}

}
