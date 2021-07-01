package com.spring.DAO;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.Scorecard_hb;

@Repository
public class ScorecardDAO_hb {
	
	public void add(Scorecard_hb scorecard) {
		SessionFactory sessionFactory = new Configuration().configure("/com/spring/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		scorecard.setDateandtime();
		try {
			session.save(scorecard);
			tx.commit();
		}
		catch(HibernateException e) {
			if (tx!=null) tx.rollback();
	         e.printStackTrace();
		}
		finally {
			session.clear();
		}
	}
	
	public List<Scorecard_hb> getPersonal(String username){
		SessionFactory sessionFactory = new Configuration().configure("/com/spring/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
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
		SessionFactory sessionFactory = new Configuration().configure("/com/spring/resources/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
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
