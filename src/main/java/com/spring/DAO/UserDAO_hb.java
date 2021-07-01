package com.spring.DAO;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.spring.model.User_hb;

@Repository
public class UserDAO_hb {
	
	private static Configuration cfg;
	private static SessionFactory sf;
	static {
		try {
			cfg = new Configuration();
			cfg.configure("com/spring/resources/hibernate.cfg.xml");
			sf = cfg.buildSessionFactory();
		}
		catch(HibernateException e) {e.printStackTrace();}
	}
	
	public boolean register(User_hb user) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			tx.commit();
			return true;
		}
		catch(HibernateException e) {
			if (tx!=null) tx.rollback();
	         e.printStackTrace();
		}
		finally {
			session.clear();
		}
		return false;
	}
	
}
