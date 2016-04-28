package com.neu.yournextcareer.dao;

import java.sql.Blob;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

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
	
	public List appliedJobs(long jobSeekerId) {
		// TODO Auto-generated method stub
		try{
			begin();
			Query q = getSession().createQuery("from Applications a where personID=:jsid)");
			q.setLong("jsid", jobSeekerId);
			List appliedJobsList = q.list();
			commit();
			return appliedJobsList;

		}catch(HibernateException he){
			System.out.println("Hibernate could not handle in checkIfJSAppliedJobs"+he);
		}
		return null;
	} 	
}
