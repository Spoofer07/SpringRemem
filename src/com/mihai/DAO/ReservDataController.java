package com.mihai.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mihai.DT.Reservations;
import com.mihai.DT.RoomDetails;

public class ReservDataController {
	
	//=================================GET TEST=========================!!!
	public Boolean checkReserv(String roomId)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Reservations.class);
		criteria.add(Restrictions.eq("reservRoomId", Integer.parseInt(roomId)));
		List<Reservations> list = criteria.list();
		if(list.isEmpty())
		{
			System.out.println("============E goala============");
		}else{
			if(list.size() > 1)
			{
				System.out.println("============E mai mare============");
			}
			else{
				System.out.println("============JUUUST right============");
			}
		}
		
		session.close();
		
		return true;
	}
	
	//===================================================================iii
	
	
	//=================================ROOM BOOKING=========================!!!
	public Boolean bookRoom(String roomId)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Reservations.class);
		criteria.add(Restrictions.eq("reservRoomId", Integer.parseInt(roomId)));
		List<Reservations> list = criteria.list();
		
		if(list.isEmpty())
		{
			//System.out.println("=========EMPTY=========");
			Reservations reserv = new Reservations();
			
			reserv.setReservBool(1);
			reserv.setReservRoomId(Integer.parseInt(roomId));
			
			session.save(reserv);
			session.getTransaction().commit();
			
			session.close();
			return true;
			
		}else{
			//System.out.println("=========iELSE=========");
			if(list.size() > 1)
			{
				session.close();
				return false;
			}
			else{
				if(list.get(0).getReservBool() == 1)
				{
					//System.out.println("=========RESERVED=========");
					session.close();
					return false;
				}
				else 	
				{
					//System.out.println("=========iiELSE=========");
					Reservations reserv = session.get(Reservations.class, list.get(0).getReservId());
					
					reserv.setReservBool(1);
					
					session.update(reserv);
					session.getTransaction().commit();
					
					session.close();
					return true;
				}
			}
		}

	}
	
//===========================================================================iii

	
	
//==========================   CANCEL RESERVATION   =============================!!!
	
	public boolean cancelReservation(String reservId)
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Reservations.class);
		criteria.add(Restrictions.eq("reservId", Integer.parseInt(reservId)));
		List<Reservations> list = criteria.list();
		
		if(list.size() > 1)
		{
			session.close();
			return false;
		}
		else
		{
			if(list.get(0).getReservBool() == 0)
			{
				session.close();
				return false;
			}
			else
			{
				Reservations reserv = session.get(Reservations.class, list.get(0).getReservId());
				
				reserv.setReservBool(0);
				
				session.update(reserv);
				session.getTransaction().commit();
				
				session.close();
				return true;
			}
		}
		
	}
	
//===============================================================================iii
	
	
	
//=================================  GET ROOM BY ID  =========================================!!!
	public Reservations getReservationById(String reservId){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Reservations reserv = session.get(Reservations.class, Integer.parseInt(reservId));
				
		session.close();
		return reserv;
	}
	
//=============================================================================================iii		

	
//=================================   GET DATA   =======================================!!!	

	public List<Reservations> getData()
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session  = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Reservations.class);
		List<Reservations> list = criteria.list();
		
		return list;
	}
	
//=====================================================================================iii
	
}
