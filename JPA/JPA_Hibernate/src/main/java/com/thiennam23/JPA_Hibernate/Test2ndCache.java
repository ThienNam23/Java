package com.thiennam23.JPA_Hibernate;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.thiennam23.JPA_Hibernate.model.Dog;

public class Test2ndCache {
	
	public static void putDog(Session session) {
        Transaction transaction = session.beginTransaction();
        
		Dog dog = new Dog(1700, "Husky");
		session.save(dog);
        transaction.commit();
	}
	private static void test2ndCache(SessionFactory sf) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Dog dog = null;
		Session session1 = sf.openSession();
		transaction = session1.beginTransaction();
		dog = (Dog)session1.get(Dog.class, 1700);
		System.out.println(dog);
		session1.close();
		
		
		Session session2 = sf.openSession();
		transaction = session2.beginTransaction();
		dog = (Dog)session2.get(Dog.class, 1700);
		System.out.println(dog);
		session2.close();
		
	}
	private static void test2ndCacheQuery(SessionFactory sf) {
		// TODO Auto-generated method stub
		Transaction transaction = null;
		Dog dog = null;
		Session session1 = sf.openSession();
		transaction = session1.beginTransaction();
		Query q1 = session1.createQuery("from Dog where did=1700");
		q1.setCacheable(true);
		dog = (Dog)q1.getSingleResult();
		System.out.println(dog);
		session1.close();
		
		
		Session session2 = sf.openSession();
		transaction = session2.beginTransaction();
		Query q2 = session2.createQuery("from Dog where did=1700");
		q2.setCacheable(true);
		dog = (Dog)q2.getSingleResult();
		System.out.println(dog);
		session2.close();
	}
	public static void main(String[] args) {
		Configuration config = new Configuration().configure().addAnnotatedClass(Dog.class);

		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build(); // cai nay cho Hibernate tu 4.3.4 tro len
		SessionFactory sf = config.buildSessionFactory(sr);

		// SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();

		/** some methods **/
		//putDog(session);
		//test2ndCache(sf);
		test2ndCacheQuery(sf);
	}
	

	
}
