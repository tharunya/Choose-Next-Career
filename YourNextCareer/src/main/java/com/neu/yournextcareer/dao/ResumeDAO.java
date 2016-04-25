package com.neu.yournextcareer.dao;

import java.sql.Blob;

import org.hibernate.HibernateException;

import com.neu.yournextcareer.exception.JobException;
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

	public Resume create(String resumeTitle, Blob content, String resumeFileType, String resumeFileName) throws JobException {
		try {
			begin();
			System.out.println("inside DAO");

			Resume resume = new Resume();

			resume.setResumeTitle(resumeTitle);  
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
}
