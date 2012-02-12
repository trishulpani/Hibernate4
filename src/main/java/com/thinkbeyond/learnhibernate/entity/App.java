package com.thinkbeyond.learnhibernate.entity;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.thinkbeyond.learnhibernate.util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction transaction = null;
    	try{
    		
    		transaction = session.beginTransaction();
    		Address address = new Address();
    		address.setCity("Kolkata");
    		address.setState("West Bengal");
    		address.setStreet("Garia");
    		address.setZipCode("700153");
    		
    		
    		Student st1 = new Student();
    		st1.setName("Nilu");
    		st1.setAddress(address);
    		
    		Student st2 = new Student();
    		st2.setName("Bharat");
    		st2.setAddress(address);
    		
    		session.save(st2);
    		session.save(st1);
    		
    		transaction.commit();
    		
    		
    	}catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
    
    }
}
