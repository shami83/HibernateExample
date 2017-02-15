package com.example.hibernate.test;

import org.hibernate.Session;

import com.example.hibernate.core.HibernateUtil;
import com.example.hibernate.entity.India;
import com.example.hibernate.entity.IndianPlayer;

public class CollectionTest {
	
	public static void main(String[] args) {
		CollectionTest test = new CollectionTest();
		test.oneToManywithIndex();
		
	}
	
	public void oneToManywithIndex(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		insertCountry();
		India india = findEntityById(1L, India.class, session);
		System.out.println(india);
		session.close();
	} 
	
	public void insertCountry() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		India  india = new India();
		india.setId(1L);;
		india.setName("INDIA");
		IndianPlayer player=new IndianPlayer();
		player.setId(1L);;
		player.setName("Virat Kohli");
		player.setSports("Cricket");
		player.setIndia(india);
		IndianPlayer player2 = new IndianPlayer();
		player2.setId(2L);;
		player2.setName("MS Dhoni");
		player2.setSports("Cricket");
		player2.setIndia(india);
		india.add(player);
		india.add(player2);
		session.save(india);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T findEntityById(Long id,Class<T> clazz,Session session) {
		return (T) session.get(clazz, id);
	}
	
	
	


}
