package com.thiennam23.JPA_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.thiennam23.JPA_Hibernate.model.Address;
import com.thiennam23.JPA_Hibernate.model.Employee;
import com.thiennam23.JPA_Hibernate.model.Laptop;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void putEmployee(Session session) {
        Transaction transaction = session.beginTransaction();
        
		Address address = new Address();
		address.setCity("Hanoi");
		address.setCountry("Viet Nam");
		
		Laptop laptop = new Laptop();
		laptop.setLid(110);
		laptop.setLname("Dell");
		
		Employee employee = new Employee();
        employee.setEid(101);
        employee.setEname("Thien Nam");
        employee.setDeg("DevOps");
        employee.setSalary(50000);
        employee.setAddress(address);
        employee.setLaptop(laptop);

		session.save(laptop);
        session.save(employee);
        transaction.commit();
	}
	public static void getEmployee(Session session) {
        Transaction transaction = session.beginTransaction();
        
		Employee employee = new Employee();
		employee = (Employee)session.get(Employee.class, 101);
		transaction.commit();
		System.out.println(employee);
	}
	public static void test2ndCache(SessionFactory sf) {
		Employee employee = new Employee();
		Transaction transaction = null;
		
		Session session1 = sf.openSession();
		transaction = session1.beginTransaction();
		employee = session1.get(Employee.class, 101);
		transaction.commit();
		System.out.println(employee);
		session1.close();
		
		Session session2 = sf.openSession();
		transaction = session2.beginTransaction();
		employee = session2.get(Employee.class, 101);
		transaction.commit();
		System.out.println(employee);
		session2.close();
	}
    public static void main( String[] args )
    {
        
        Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class);
        
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build(); // cai nay cho Hibernate tu 4.3.4 tro len
        SessionFactory sf = config.buildSessionFactory(sr);
        
        //SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        
        /** some methods **/
        test2ndCache(sf);
        //putEmployee(session);
        //getEmployee(session);
    }
}
