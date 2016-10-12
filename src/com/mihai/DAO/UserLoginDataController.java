package com.mihai.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mihai.DT.LoginDetails;

public class UserLoginDataController {

	
	public void printData()
	{
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(LoginDetails.class);
		List<LoginDetails> users = criteria.list();
		for(LoginDetails usr : users)
		{
			System.out.println(usr.getUser() + " ---- " + usr.getPass());
		}
		
		session.close();
		
	}
	
	public List<LoginDetails> getUserLoginData(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(LoginDetails.class);
		
		List<LoginDetails> theList = criteria.list();
		session.getTransaction().commit();
		session.close();
		
		return theList;
	}
	

	public void saveUser(LoginDetails newUser)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(newUser);
		
		session.getTransaction().commit();
		session.close();
	}
}
