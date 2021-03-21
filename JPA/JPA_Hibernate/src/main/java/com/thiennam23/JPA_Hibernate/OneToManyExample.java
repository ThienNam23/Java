package com.thiennam23.JPA_Hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.thiennam23.JPA_Hibernate.model.Company;
import com.thiennam23.JPA_Hibernate.model.Product;

public class OneToManyExample {
	
	public static void putCompany(Session session) {
		
		Transaction transaction = session.beginTransaction();
		Product p1 = new Product(1200, "Laptop");
		Product p2 = new Product(1201, "Smart Phone");
		List<Product> products = Arrays.asList(p1, p2);
		
		Company company = new Company();
		company.setCid(1001);
		company.setCname("Dell Company");
		company.setProducts(products);
		
		p1.setCompany(company);
		p2.setCompany(company);
		session.save(p1);
		session.save(p2);
		session.save(company);
		
        transaction.commit();
	}
	public static void getCompany(Session session) {
		Transaction transaction = session.beginTransaction();
		Company Company = new Company();
		Company = (Company)session.get(Company.class, 1001);
		transaction.commit();
		System.out.println(Company);
	}
    public static void main( String[] args )
    {
        
        Configuration config = new Configuration().configure("hibernate_onetomany.cfg.xml").addAnnotatedClass(Company.class).addAnnotatedClass(Product.class);
        
        //ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        //SessionFactory sf = config.buildSessionFactory(registry);
        
        SessionFactory sf = config.buildSessionFactory();
        Session session = sf.openSession();
        
        // some methods
        putCompany(session);
        getCompany(session);
    }
}
