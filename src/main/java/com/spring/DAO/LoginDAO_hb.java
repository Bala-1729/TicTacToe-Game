package com.spring.DAO;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.spring.model.Login_hb;
import com.spring.model.User_hb;

@Repository
public class LoginDAO_hb {
	
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
	
	public boolean login(Login_hb login) {
		Session session = sf.openSession();
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
