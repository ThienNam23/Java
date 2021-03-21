package com.thiennam23.JPA_Hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.thiennam23.JPA_Hibernate.model.Person;


public class HqlExample 
{
	public static void HqlManyRecords(Session session) {
	    Transaction transaction = session.beginTransaction();
		/** truy xuat nhieu ban ghi voi dieu kien **/
	    Query q1 = session.createQuery("from Person where personAge > 30"); // Person khong phai la ten table ma la ten Entity
//	    System.out.println("Start fetching!");
	    List<Person> persons = q1.list();
//	    System.out.println("All data fetched!");
	    for (Person person : persons) {
			System.out.println(person);
		}
	    transaction.commit();
	}
	public static void HqlOneRecords(Session session) {

	    Transaction transaction = session.beginTransaction();
		 /** Truy xuat 1 ban ghi duy nhat **/
	    Query q1 = session.createQuery("from Person where personId = 10");
	    Person person = (Person)q1.uniqueResult();
	    System.out.println(person);
	    transaction.commit();
	}
	public static void HqlSpecificColumns(Session session) {
	    Transaction transaction = session.beginTransaction();
		/** Truy xuat theo tung cot **/
	    int b = 23;
	    Query q1 = session.createQuery("select personName, personAge from Person s where s.personId = :b");
	    q1.setParameter("b", b);
	    Object[] pObject = (Object[])q1.uniqueResult();
	    // co the dung: System.out.println(pObject[0] + " : " + pObject[1]);
	    for (Object object : pObject) {
			System.out.println(object);
		}
	    
	    // select sum(personAge) from Person s: return Long : uniqueQuery
	    // select personName, personAge from Person s: return List<Object[]>
	    transaction.commit();
	}
	public static void Sql(Session session) {

	    Transaction transaction = session.beginTransaction();
		/**
	     * SQL query
	     */
	    NativeQuery sql = session.createSQLQuery("select * from Person where personId = 23");
	    sql.addEntity(Person.class);
	    List<Person> persons = sql.list();
	    for (Person p : persons) {
			System.out.println(p);
		}
	    transaction.commit();
	}
	public static void SqlSpecificColumns(Session session) {
		Transaction transaction = session.beginTransaction();
		/**
	     * SQL query
	     */
	    NativeQuery sql = session.createSQLQuery("select personName, personAge from Person where personAge > 30");
	    sql.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
	    List persons = sql.list();
	    for (Object o : persons) {
	    	Map map = (Map)o;
			System.out.println(map.get("personName") + " : " + map.get("personAge"));
		}
	    transaction.commit();
	}
	public static void SqlDelete(Session session) {
		Transaction transaction = session.beginTransaction();
		/**
	     * SQL query
	     */
	    NativeQuery sql = session.createSQLQuery("delete from Person where personId = 23");
	    sql.executeUpdate();
	    transaction.commit();
	}
	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure("hibernate_hql.cfg.xml").addAnnotatedClass(Person.class);
	    
	    ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build(); // cai nay cho Hibernate tu 4.3.4 tro len
	    SessionFactory sf = config.buildSessionFactory(sr);
	    
	    //SessionFactory sf = config.buildSessionFactory();
	    Session session = sf.openSession();
	    
	    // execute some method here
	    
	    
	    session.close();
	    
	}
    
    
    
}
