package com.example.hibernate.test;

import org.hibernate.Session;

import com.example.hibernate.core.HibernateUtil;
import com.example.hibernate.entity.Employee;

public class TestApplication {
	public static void main(String[] args) {

		TestApplication app = new TestApplication();
		app.insertEmployee();
		app.findEmployeeById(1);
		app.loadEmployeeById(1);
		HibernateUtil.shutdown();

	}

	public void insertEmployee() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Employee emp = new Employee();
		emp.setEmpId(1);
		emp.setEmail("mitrashamik@mail.com");
		emp.setName("Shamik Mitra");
		session.save(emp);
		session.getTransaction().commit();
		session.close();
	}

	public void findEmployeeById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee emp2 = (Employee) session.get(Employee.class, id);
		System.out.println("Successfully Fetch " + emp2);	
		session.close();
	}
	
	public void loadEmployeeById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee emp2 = (Employee) session.load(Employee.class, id);
		System.out.println("Successfully lazy Fetch");
		System.out.println("No queery fired on data base , Proxy returned.");
		System.out.println("Now query fired on data base: " + emp2.getName());
		session.close();
		
	}
}