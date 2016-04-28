package com.neu.yournextcareer.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.yournextcareer.exception.JobException;

public class EmployerDAO extends DAO{
    public List list() throws JobException {
        try {
            begin();
            Query q = getSession().createQuery("from Employer");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new JobException("Could not list the employers", e);
        }
    }

   /** public List listJobsByEmployer(Long eid) throws JobException {
    	try{
    		begin();
    	      Query q = getSession().createQuery("from Job where employer :eid");
              List list = q.list();
              commit();
              return list;
          } catch (HibernateException e) {
              rollback();
              throw new JobException("Could not list the employers", e);
          }
    }**/

}
