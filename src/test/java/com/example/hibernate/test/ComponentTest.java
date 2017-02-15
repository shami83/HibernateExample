/**
 * 
 */
package com.example.hibernate.test;

import org.hibernate.Session;

import com.example.hibernate.core.HibernateUtil;
import com.example.hibernate.entity.Address;
import com.example.hibernate.entity.JobSeeker;

/**
 * @author Shamik Mitra
 *
 */
public class ComponentTest {

	public static void main(String[] args) {
		ComponentTest test = new ComponentTest();
		test.componentMappingTest();
	}

	public void componentMappingTest() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		insertJobSeeker();
		JobSeeker jSeeker = findEntityById(1, JobSeeker.class, session);
		System.out.println(jSeeker);
		session.close();
	}

	public void insertJobSeeker() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		JobSeeker jobSeeker = new JobSeeker();
		jobSeeker.setJobSeekerId(1);
		jobSeeker.setName("Shamik Mitra");
		jobSeeker.setEmail("jobseeker@example.com");
		Address address = new Address();
		address.setAddress("Bagbazar");
		address.setZip("700003");
		jobSeeker.setAddress(address);
		session.save(jobSeeker);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public <T> T findEntityById(Integer id, Class<T> clazz, Session session) {
		return (T) session.get(clazz, id);
	}

}
