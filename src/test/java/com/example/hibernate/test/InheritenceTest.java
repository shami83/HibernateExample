/**
 * 
 */
package com.example.hibernate.test;

import org.hibernate.Session;

import com.example.hibernate.core.HibernateUtil;
import com.example.hibernate.entity.MultinationalCompany;
import com.example.hibernate.entity.NationalCompany;

/**
 * @author Shamik Mitra
 *
 */
public class InheritenceTest {
	
	public static void main(String[] args) {
		InheritenceTest test = new InheritenceTest();
		test.testSingleTableInheritence();
		
		}
	public void testSingleTableInheritence()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		insertCompanies();
		NationalCompany comp = findEntityById(1L,NationalCompany.class,session);
		MultinationalCompany mComp = findEntityById(2L,MultinationalCompany.class,session);
		System.out.println(comp);
		System.out.println(mComp);
		session.close();
	}
	
	private  void insertCompanies() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		NationalCompany nCompany = new NationalCompany();
		nCompany.setCompanyId(1L);
		nCompany.setName("Infosys");
		nCompany.setCompanyStrength(1000000L);
		nCompany.setHeadOfficeState("Bengaluru");
		
		MultinationalCompany mCompany = new MultinationalCompany();
		mCompany.setCompanyId(2L);
		mCompany.setName("IBM");
		mCompany.setCompanyStrength(10000000L);
		mCompany.setHeadOfficeCountry("USA");
		
		
		session.save(nCompany);
		session.save(mCompany);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getCompany(Long id,Class<T> clazz,Session session) {
		return (T) session.get(clazz, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> T findEntityById(Long id,Class<T> clazz,Session session) {
		return (T) session.get(clazz, id);
	}
	

}
