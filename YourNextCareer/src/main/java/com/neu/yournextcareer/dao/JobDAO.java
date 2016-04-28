package com.neu.yournextcareer.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.yournextcareer.exception.JobException;
import com.neu.yournextcareer.pojo.Applications;
import com.neu.yournextcareer.pojo.Job;

public class JobDAO extends DAO {

	public Job get(long jobId) throws Exception {
		try {
			System.out.println("In Job DAO");
			begin();

			System.out.println("Begin trans");
			Query q = getSession().createQuery("from Job where jobID = :jid");

			System.out.println("Create");
			q.setLong("jid", jobId);
			Job job = (Job) q.uniqueResult();
			System.out.println("Job uniqueResult"+job);
			commit();
			System.out.println("Job uniqueResultafter commit"+job);
			//  getSession().save(job);			
			return job;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get the job assigned for the  " + jobId, e);
		}
	}

	public Job create(String jobTitle, String jobType, String jobCategory, String jobDescription,
			String jobRequirement, String jobResponsibility, String jobLocation, String jobCompany, Date jobPostedDate)
	// String jobStatus, Date jobPostedDate, Date jobAppliedDate, Date jobStatusChangedDate
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
			job.setJobPostedDate(new Date());
			job.setJobStatus("Available");
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
			Query applicationRetrieval =getSession().createQuery("from Applications where job.jobID=:jobId");
			applicationRetrieval.setLong("jobId",jobId);
			System.out.println("job Id from method"+jobId);
			applicationList=applicationRetrieval.list();
			commit();
		}
		catch(Exception e){
			rollback();
			System.out.println(applicationList.size());

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

	public List<Job> jobsAvailableForSpecificSeeker(Long jobSeekerId) throws Exception{
		List<Job> unappliedJobs = null;

		try{
			System.out.println("JobSeeker id in jobs available method"+jobSeekerId);

			begin();
			Query q = getSession().createQuery("from Job j where j.jobID NOT IN"+ "(select a.job from Applications a"
					+ " where a.person.personID=:pid)");
			q.setLong("pid", jobSeekerId);
			unappliedJobs = q.list();
			commit();
			System.out.println("Unapplied jobs"+unappliedJobs);
			return unappliedJobs;
		}catch(Exception e){
			rollback();
			throw new Exception("Could not get jobs", e);
		}
	}
}
