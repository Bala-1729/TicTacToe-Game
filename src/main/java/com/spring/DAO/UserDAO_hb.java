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
	
	public boolean register(User_hb user) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
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
