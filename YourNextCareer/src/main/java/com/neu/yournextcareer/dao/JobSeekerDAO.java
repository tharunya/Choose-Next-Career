package com.neu.yournextcareer.dao;

import org.hibernate.Query;

import com.mysql.jdbc.Blob;
import com.neu.yournextcareer.pojo.Resume;

public class JobSeekerDAO extends DAO{

	public void uploadResume(long personId, Blob resumeContent, String originalFilename, String contentType) {
		begin();
		Query q = getSession().createQuery("from JobSeeker where personId = :personId");
		 q.setLong("personId",personId);
		 System.out.println(resumeContent);
		 Resume resume = (Resume) q.uniqueResult(); 
		 System.out.println(contentType);
		 resume.setContent(resumeContent);
		 resume.setResumeFileName(originalFilename);
		 resume.setResumeFileType(contentType);
		 
		 getSession().update(resume);
		 commit();	
	}	
}