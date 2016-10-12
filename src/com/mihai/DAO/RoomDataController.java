package com.mihai.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mihai.DT.RoomDetails;

public class RoomDataController {
	
//=================================   PRINT DATA   =======================================!!!		
	public void printData(){
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(RoomDetails.class);
		List<RoomDetails> list = criteria.list();
		for(RoomDetails room : list)
		{
			System.out.println("Name: " + room.getRoomName() + "No. of places" + room.getNoOfPlaces());
		}
		session.close();
		
	}
//=======================================================================================iii
	
	
//=================================   GETTING A LIST WITH ALL THE DATA   ========================================!!!	
	public List<RoomDetails> getData(){
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(RoomDetails.class);
		List<RoomDetails> list = criteria.list();
		session.close();
		
		return list;
	}
	
//===============================================================================================================iii

	
//=================================   GET ROOM BY ID   =======================================!!!	
	public RoomDetails getRoomById(String id){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		RoomDetails room = session.get(RoomDetails.class, Integer.parseInt(id));
				
		session.close();
		
		return room;
	}
	
//============================================================================================iii	

	
//=================================   GET ROOM BY NAME   =======================================!!!		
	public RoomDetails getRoomByName(String name)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(RoomDetails.class);
		criteria.add(Restrictions.eq("roomName", name));
		List<RoomDetails> rooms = criteria.list();
		RoomDetails room = rooms.get(0);
		
		session.close();
		return room;
	}
//=============================================================================================iii	

}
