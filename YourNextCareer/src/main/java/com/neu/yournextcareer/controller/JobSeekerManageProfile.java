package com.neu.yournextcareer.controller;

import java.io.IOException;
import java.sql.Blob;

import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neu.yournextcareer.dao.PersonDAO;
import com.neu.yournextcareer.dao.ResumeDAO;
import com.neu.yournextcareer.exception.JobException;
import com.neu.yournextcareer.pojo.JobSeeker;
import com.neu.yournextcareer.pojo.Person;
import com.neu.yournextcareer.pojo.Resume;

@Controller
public class JobSeekerManageProfile {
	@RequestMapping(value = "/upresume.htm", method = RequestMethod.POST)
	public String doSubmitAction(@RequestParam("resumefile") MultipartFile resumefile, @RequestParam("skills")String skills, HttpSession session, Model model) throws IOException {
		try {			

			if(!resumefile.getOriginalFilename().isEmpty()){
				PersonDAO personDAO = new PersonDAO();
				ResumeDAO resumeDao = new ResumeDAO();
				System.out.println("hi");
				Blob blob = (Blob) Hibernate.createBlob(resumefile.getInputStream());
				//Blob blob = (Blob) Hibernate.createBlob(photo.getInputStream());
				String resumecontent = resumefile.getContentType();
				String resumeName = resumefile.getOriginalFilename();
				Resume resume = new Resume();
				resume.setContent(blob);
				resume.setResumeFileType(resumecontent);
				resume.setResumeFileName(resumeName);
				resume.setSkills(skills);

				resumeDao.create(resume.getContent(),resume.getResumeFileType(),resume.getResumeFileName());

				Person js = (Person) session.getAttribute("personSession");
				System.out.println("getting js");
				String jobSeekerEmail = js.getEmailID();

				JobSeeker js1 = (JobSeeker) personDAO.lookUpPersonByEmail(jobSeekerEmail);
				js1.setResume(resume);

				resumeDao.save(resume);
				//  jobDao.save(job);  
				model.addAttribute("resumefilename",resumeName);
						
				return "jobSeekerUpdateProfile";
			}
			else if(resumefile.getOriginalFilename().isEmpty()){
				model.addAttribute("error",true);
				return "resumeNotFound";
			}
		}
		catch (NullPointerException n){
			System.out.println("executed catch");
			model.addAttribute("error",true);
			//return "empreg";
		} catch (JobException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "jobSeekerUpdateProfile";
	}

}
