package com.spring.DAO;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.spring.model.Scorecard_hb;

@Repository
public class ScorecardDAO_hb {
	
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
	
	public boolean add(Scorecard_hb scorecard) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		scorecard.setDateandtime();
		try {
			session.save(scorecard);
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
	
	public List<Scorecard_hb> getPersonal(String username){
		Session session = sf.openSession();
		List<Scorecard_hb> list = new ArrayList<>();
		try {
			Query query = session.createQuery("From Scorecard_hb where username= :uname");
			query.setParameter("uname", username);
			List l = query.getResultList();
			for(Object o:l) {
				((Scorecard_hb)o).setDate();
				list.add((Scorecard_hb)o);
				System.out.println(o);
			}
		}
		catch(HibernateException e) {
	         e.printStackTrace();
		}
		finally {
			session.clear();
		}
		return list;
	}
	
	public List<Scorecard_hb> getGlobal(){
		Session session = sf.openSession();
		List<Scorecard_hb> list = new ArrayList<>();
		try {
			Query query = session.createQuery("From Scorecard_hb");
			List l = query.list();
			for(Object o:l) {
				((Scorecard_hb)o).setDate();
				list.add((Scorecard_hb)o);
			}
		}
		catch(HibernateException e) {
	         e.printStackTrace();
		}
		finally {
			session.clear();
		}
		return list;
	}
}
