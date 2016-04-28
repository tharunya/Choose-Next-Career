package com.neu.yournextcareer.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.yournextcareer.exception.JobException;
import com.neu.yournextcareer.pojo.Applications;
import com.neu.yournextcareer.pojo.Job;
import com.neu.yournextcareer.pojo.JobSeeker;
import com.neu.yournextcareer.pojo.Person;

public class ApplicationsDAO extends DAO {
	public Applications get(long aid) throws Exception {
		try {
			System.out.println("In Application DAO");
			begin();

			System.out.println("Begin trans");
			Query q = getSession().createQuery("from Applications where appId=:appid");

			System.out.println("Creating application");
			System.out.println("Query :  "+q);

			q.setLong("appid", aid);
			System.out.println("AID"+aid);
			Applications application = (Applications) q.uniqueResult();
			System.out.println("application"+application);
			commit();
			System.out.println("application after commit"+application);
			return application;
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			throw new Exception("Could not get the application assigned for the " + aid, e);
		}
	}

	public Applications saveApplication(Job job, Person person)
			throws JobException {
		try {
			begin();
			System.out.println("inside Save Applied");

			Applications app = new Applications();
			System.out.println("new inst of app"+app);

			app.setApplicationStatus("Applied");
			app.setJob(job);
			app.setPerson(person);

			System.out.println("App set"+app);
			getSession().save(app);
			System.out.println("session app"+app.getApplicationStatus());
			System.out.println("session app job"+app.getJob());
			System.out.println("Session Person"+app.getPerson());
			commit();
			return app;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create person " + job , e);
			throw new JobException("Exception while saving application: " + e.getMessage());
		}
	}

	public void save(Applications app) throws JobException{
		try{
			begin();
			getSession().saveOrUpdate(app);
			commit();
		}catch(HibernateException he){
			rollback();
			System.out.println("Exception while saving app : "+he);
		}
	}

	public void delete(Applications app) throws Exception {
		try {
			begin();

			getSession().delete(app);

			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not delete app " + app.getApplicationStatus(), e);
		}
	}

	public List listByApplicationStatus(String status) throws JobException {
		try {
			begin();
			Query q = getSession().createQuery("from Applications where applicationStatus= :status");
			q.setString("status",status);
			List list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new JobException("Could not list the applications", e);
		}
	}

	public List getApplicationsBySpecificJobSeeker(Long jsid) throws JobException {
		try {
			begin();
			Query q = getSession().createQuery("from Applications a, Person p where a.person.personID=p.pid and a.person.personID=:jsid");
			q.setLong("jsid", jsid);

			List appList = q.list();
			System.out.println("Application List by specific job seeker"+appList+"with jsid"+jsid);
			//	String result=(String) q.uniqueResult();
			commit();
			return appList;
		} catch (HibernateException e) {
			rollback();
			throw new JobException("Could not list the applications", e);
		}
	}

	public Boolean checkResume(long personID) {
		JobSeeker j=new JobSeeker();
		try{
			begin();
			Query q=getSession().createQuery("from JobSeeker where personID=:personID");
			q.setLong("personID",personID);
			j=(JobSeeker)q.uniqueResult();

			if(j.getResume().getResumeFileName()!=null){
				return true;
			}
			commit();
		}
		catch(Exception e){
			rollback();
		}
		return false;

	}

	public Boolean checkIfJSApplied(long jobId) {
		// TODO Auto-generated method stub
		ApplicationsDAO appsDAO = new ApplicationsDAO();
		Applications apps = new Applications();
		Person person = null;

		try{
			begin();
			Query q = getSession().createQuery("from Job where jobID not IN (from Applications a where a.appid=:jobId)");
			q.setLong("jobId", jobId);
			Job unappliedJob = (Job) q.uniqueResult();

		}catch(HibernateException he){
			System.out.println("Hibernate could not handle in checkIfJSApplied"+he);
		}
		return null;
	}

	public void changeApplicationStatus(String status,long appId){
		ApplicationsDAO appsDAO = new ApplicationsDAO();
		Applications apps = new Applications();
		Person person = null;

		try{
			begin();
			Query q = getSession().createQuery("from Applications where appId=:appId");
			q.setLong("appId",appId);
			Applications jobApplication = (Applications) q.uniqueResult();

			jobApplication.setApplicationStatus(status);
			getSession().saveOrUpdate(jobApplication);
			commit();
			System.out.println("app status in App DAO"+jobApplication.getApplicationStatus());
		}catch(HibernateException he){
			System.out.println("Hibernate could not handle in checkIfJSApplied"+he);
		}
	}
	
	public List allAppliedJobs() {
		// TODO Auto-generated method stub
		try{
			begin();
			Query q = getSession().createQuery("from Applications)");
		//	q.setLong("appId", appId);
			List allAppliedJobsList = q.list();
			commit();
			return allAppliedJobsList;

		}catch(HibernateException he){
			System.out.println("Hibernate could not handle in all applied Jobs "+he);
		}
		return null;
	} 	
}