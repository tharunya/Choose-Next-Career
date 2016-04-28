package com.neu.yournextcareer.dao;

import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.yournextcareer.exception.JobException;
import com.neu.yournextcareer.pojo.JobSeeker;
import com.neu.yournextcareer.pojo.Resume;

public class ResumeDAO extends DAO{

	public void save(Resume resume) throws JobException {
		try {
			begin();
			getSession().saveOrUpdate(resume);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new JobException("Could not save the job", e);
		}
	}

	public Resume create(Blob content, String resumeFileType, String resumeFileName) throws JobException {
		try {
			begin();
			System.out.println("inside DAO");

			Resume resume = new Resume();

			//resume.setResumeTitle(resumeTitle);  
			resume.setContent(content);
			resume.setResumeFileType(resumeFileType);
			resume.setResumeFileName(resumeFileName);
			System.out.println("Resume in dao"+resume);
			getSession().save(resume);

			commit();
			return resume;
		} catch (HibernateException e) {
			rollback();

			throw new JobException("Exception while creating user: " + e.getMessage());
		}
	}

	public void updateResume(long id,JobSeeker j) throws Exception {
		try{
			begin();
//			System.out.println(j.getSkill());

			Query q = getSession().createQuery("from Jobseeker where personID=:pid");
			q.setLong("pid", id);
			JobSeeker js = (JobSeeker)q.uniqueResult();
			js.setFirstName(j.getFirstName());
			js.setLastName(j.getLastName());
			js.setPassword(j.getPassword());
			js.setEmailID(j.getEmailID());

			//Resume
	/**		js.setFileName(j.getResume().getOriginalFilename());
			js.setFileType(j.getResume().getContentType());
			Blob blob =(Blob) Hibernate.createBlob(j.getResume().getInputStream()); 
			js.setContent(blob);
			getSession().update(js);**/
			commit();
		}
		catch (Exception e) {
			rollback();
			e.printStackTrace();
		}

	}
}
