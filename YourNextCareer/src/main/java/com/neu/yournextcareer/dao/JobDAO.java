package com.neu.yournextcareer.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.yournextcareer.exception.JobException;
import com.neu.yournextcareer.pojo.Applications;
import com.neu.yournextcareer.pojo.Employer;
import com.neu.yournextcareer.pojo.Job;
import com.neu.yournextcareer.pojo.JobSeeker;
import com.neu.yournextcareer.pojo.Person;

public class JobDAO extends DAO {

	public Job get(String jid) throws Exception {
		try {
			System.out.println("In Job DAO");
			begin();

			System.out.println("Begin trans");
			Query q = getSession().createQuery("from Job where jobID = :jid");

			System.out.println("Create");
			q.setString("jid", jid);
			Job job = (Job) q.uniqueResult();
			System.out.println("Job uniqueResult"+job);
			commit();
			System.out.println("Job uniqueResultafter commit"+job);
			//  getSession().save(job);			
			return job;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get the job assigned for the  " + jid, e);
		}
	}

	public Job create(String jobTitle, String jobType, String jobCategory, String jobDescription,
			String jobRequirement, String jobResponsibility, String jobLocation, String jobCompany)
					throws JobException {
		try {
			begin();
			System.out.println("inside Job DAO");

			Job job = new Job();
			System.out.println("new inst of job");

			job.setJobTitle(jobTitle);
			job.setJobType(jobType);
			job.setJobCategory(jobCategory);
			job.setJobDescription(jobDescription);
			job.setJobRequirement(jobRequirement);
			job.setJobResponsibilities(jobResponsibility);
			job.setJobLocation(jobLocation);
			job.setJobCompany(jobCompany);
			System.out.println("job set");

			//	getSession().save(job);
			//			 System.out.println("not saved");


			commit();
			return job;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create person " + job , e);
			throw new JobException("Exception while creating job: " + e.getMessage());
		}
	}

	public void save(Job job) throws JobException{
		try{
			begin();
			getSession().saveOrUpdate(job);
			commit();
		}catch(HibernateException he){
			rollback();
			System.out.println("Exception while saving job"+he);
		}
	}

	public void delete(Job job) throws Exception {
		try {
			begin();

			getSession().delete(job);

			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not delete job " + job.getJobTitle(), e);
		}
	}

	public List list() throws JobException {
		try {
			begin();
			Query q = getSession().createQuery("from Job");
			List list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new JobException("Could not list the jobs", e);
		}
	}

	public List<Applications> getApplications(long jobId) {
		//	Applications applications=new Applications();// TODO Auto-generated method stub

		List<Applications> applicationList=null;

		try{
			begin();
			applicationList=new ArrayList<Applications>();
			Query jobRetrieval =getSession().createQuery("from Job where jobID=:jobID");
			jobRetrieval.setLong("jobID",jobId);
			System.out.println("job Id from method"+jobId);
			Job job=(Job) jobRetrieval.uniqueResult();

			System.out.println("Job retrieval"+job);

			Query applicationRetrieval=getSession().createQuery("from Applications where job=:job");
			applicationRetrieval.setLong("job", jobId);
			System.out.println("Job aplication"+applicationRetrieval+"job set"+jobId);
			applicationList=applicationRetrieval.list();
			System.out.println("Application list"+applicationList);

			commit();
		}
		catch(Exception e){
			rollback();
		}
		System.out.println(applicationList.size());
		return applicationList;
	}

	public void changeStatus(String status, Long appId) {
		// TODO Auto-generated method stub

		Applications app=new Applications();

		try{
			begin();
			Query q=getSession().createQuery("from Applications where id=:ajID");
			q.setLong("ajID", appId);
			app =(Applications) q.uniqueResult();
			app.setApplicationStatus(status);

			getSession().update(app);


			commit();

		}
		catch(Exception e){
			e.printStackTrace();
			rollback();
		}

	}

	public Long jobSize(){
		Job job = new Job();
		Long jobSize = null;
		try{
			begin();
			Query q=getSession().createQuery("From Job where jobID=:jid");
			List list = q.list();
			jobSize = (long) list.size();
		}catch(Exception e){
			e.printStackTrace();
			rollback();
		}

		return jobSize;
	}

}
