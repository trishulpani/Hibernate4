package com.thinkbeyond.learnhibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static SessionFactory SESSIONFACTORY = null;
	private static ServiceRegistry SERVICEREGISTRY = null;
	
	static{
		
		try{
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			
			SERVICEREGISTRY = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			SESSIONFACTORY = configuration.buildSessionFactory(SERVICEREGISTRY);
			
			
		}catch (Exception e) {
			System.err.println("Initial SessionFactory creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public  static SessionFactory getSessionFactory(){
		return SESSIONFACTORY;
	}
	
}
