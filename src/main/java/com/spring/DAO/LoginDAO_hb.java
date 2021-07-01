package com.spring.DAO;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Login_hb;
import com.spring.model.User_hb;

@Repository
public class LoginDAO_hb {
	
	public boolean login(Login_hb login) {
		SessionFactory sessionFactory = new Configuration().configure("/com/spring/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Object obj = session.get(Login_hb.class,login.getUsername());
			Login_hb s = (Login_hb)obj;
			
			if(s.getUsername().equals(login.getUsername()) && s.getPassword().equals(login.getPassword())) {return true;}
		}
		catch(HibernateException e) {
	         e.printStackTrace();
		}
		finally {
			session.clear();
		}
		return false;
	}
	
}
