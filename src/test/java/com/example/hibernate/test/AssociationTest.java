package com.example.hibernate.test;

import org.hibernate.Session;

import com.example.hibernate.core.HibernateUtil;
import com.example.hibernate.entity.BadmintonPlayer;
import com.example.hibernate.entity.Country;
import com.example.hibernate.entity.CricketPlayer;
import com.example.hibernate.entity.Player;
import com.example.hibernate.entity.Team;

public class AssociationTest {
	
public static void main(String[] args) {
	AssociationTest test = new AssociationTest();
	//test.manyToOne();
	//test.oneToOne();
	//test.oneToMany();
	test.manyTomany();
	
	}

public void oneToMany(){
	Session session = HibernateUtil.getSessionFactory().openSession();
	insertCountry();
	insertPlayers();
	Country country = findEntityById(1L, Country.class, session);
	System.out.println(country);
	session.close();
} 

public void oneToOne(){
	Session session = HibernateUtil.getSessionFactory().openSession();
	insertCountry();
	insertBadmintonPlayer();
	BadmintonPlayer player = findEntityById(1L, BadmintonPlayer.class, session);
	System.out.println(player);
	session.close();
} 
public void manyToOne(){
	Session session = HibernateUtil.getSessionFactory().openSession();
	insertCountry();
    insertPlayers();
	Player player = findEntityById(1L, Player.class, session);
	Player player2 =findEntityById(2L, Player.class, session);
	System.out.println(player);
	System.out.println(player2);
	session.close();
}

public void manyTomany(){
	Session session = HibernateUtil.getSessionFactory().openSession();
	insertTeams();
	insertCricketPlayer();
	CricketPlayer player = findEntityById(1L, CricketPlayer.class, session);
	System.out.println(player);
	session.close();
}
	
	public void insertCountry() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Country  country = new Country();
		country.setId(1L);;
		country.setName("INDIA");		
		session.save(country);
		session.getTransaction().commit();
		session.close();
	}
	

	public void insertTeams() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Team  team = new Team();
		team.setId(1L);;
		team.setName("KKR");	
		
		Team  team1 = new Team();
		team1.setId(2L);
		team1.setName("TRINIDAD");
		
		session.save(team);
		session.save(team1);
		session.getTransaction().commit();
		session.close();
	}
	public void insertBadmintonPlayer() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		BadmintonPlayer player = new BadmintonPlayer();
		Country  country = this.findEntityById(1L, Country.class , session);
		player.setId(1L);;
		player.setName("PV SINDHU");
		player.setSports("Badminton");
		player.setCountry(country);		
		session.save(player);
		session.getTransaction().commit();
		session.close();
	}
	
	public void insertCricketPlayer() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		CricketPlayer player = new CricketPlayer();
		Team  team1 = this.findEntityById(1L, Team.class , session);
		Team  team2 = this.findEntityById(2L, Team.class , session);
		player.setId(1L);;
		player.setName("Sunil Narine");
		player.setSports("Cricket");
		player.addTeam(team1);
		player.addTeam(team2);
		session.save(player);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public void insertPlayers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Player player = new Player();
		Country  country = this.findEntityById(1L, Country.class , session);
		player.setId(1L);;
		player.setName("Virat Kohli");
		player.setSports("Cricket");
		player.setCountry(country);
		Player player2 = new Player();
		player2.setId(2L);;
		player2.setName("MS Dhoni");
		player2.setSports("Cricket");
		player2.setCountry(country);
		
		session.save(player);
		session.save(player2);
		session.getTransaction().commit();
		session.close();
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> T findEntityById(Long id,Class<T> clazz,Session session) {
		return (T) session.get(clazz, id);
	}
	
	

}
