package com.neu.yournextcareer.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.yournextcareer.exception.EmailException;
import com.neu.yournextcareer.pojo.Employer;
import com.neu.yournextcareer.pojo.JobSeeker;
import com.neu.yournextcareer.pojo.Person;

public class PersonDAO extends DAO {

	public PersonDAO() {
	}

	public Person get(String eid) throws EmailException {
		try {
			begin();
			Query q = getSession().createQuery("from Person where emailID = :eid");
			q.setString("eid", eid);
			Person person = (Person) q.uniqueResult();
			commit();
			return person;
		} catch (HibernateException e) {
			rollback();
			throw new EmailException("Could not get user registered for the  " + eid, e);
		}
	}

	public Person lookUpPersonByEmailAndPassword(String eid, String pwd) {
		try {
			begin();
			System.out.println("Begin");
			Query q = getSession().createQuery("from Person where emailID=:eid and password=:pwd");
			q.setString("eid", eid);
			q.setString("pwd", pwd);
			System.out.println("Email id"+eid+"pwd"+pwd);
			Person person = (Person) q.uniqueResult();
			System.out.println("Person"+person);
			commit();
			System.out.println("dao"+person.getEmailID());
			return person;
			
		} catch (HibernateException e) {
			rollback();
			throw new HibernateException("Could not get user from the  " + e);
		}
	}
	
	public Person lookUpPersonByEmail(String eid) {
		try {
			begin();
			Query q = getSession().createQuery("from Person where emailID = :eid");
			q.setString("eid", eid);
			Person person = (Person) q.uniqueResult();
			commit();
			return person;
			
		} catch (HibernateException e) {
			rollback();
			throw new HibernateException("Could not get employer from the session. Message :  " + e);
		}
	}
	
	public boolean create(String role, String password, String emailId, String firstName, String lastName, String confirmPassword, String confirmEmailID)
			throws EmailException {
		try {
			begin();
	//		System.out.println("inside Person DAO");

			if (role == "Job Seeker") {
				JobSeeker seeker = new JobSeeker();
				seeker.setFirstName(firstName);
				seeker.setLastName(lastName);
				seeker.setEmailID(emailId);
				seeker.setConfirmEmailID(confirmEmailID);
				seeker.setPassword(password);
				seeker.setConfirmPassword(confirmPassword);
				seeker.setRole("Job Seeker");
		//		seeker.setCompanyName(companyName);
		
				getSession().save(seeker);

				commit();
				return true;
			} else if (role == "Employer") {
				Employer emp = new Employer();
				emp.setFirstName(firstName);
				emp.setLastName(lastName);
				emp.setEmailID(emailId);
				emp.setConfirmEmailID(confirmEmailID);
				emp.setPassword(password);
				emp.setConfirmPassword(confirmPassword);
				emp.setRole("Employer");
			//	emp.setCompanyName(companyName);

				getSession().save(emp);

				commit();
				return true;

			}
			return false;

		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create person " + person, e);
			throw new EmailException("Exception while creating person: " + e.getMessage());
		}
	}

	public void delete(Person person) throws Exception {
		try {
			begin();

			getSession().delete(person);

			commit();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not delete person " + person.getFirstName(), e);
		}
	}
}