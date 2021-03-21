package com.thiennam23.web.repo;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.thiennam23.web.model.Employee;

public class EmployeeRepo {
	
	private Configuration config = new Configuration().configure().addAnnotatedClass(Employee.class);
    private ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build(); // cai nay cho Hibernate tu 4.3.4 tro len
    private SessionFactory sf = config.buildSessionFactory(sr);
    
    public void addEmployee(Employee employee) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
	}

	public List<Employee> findAllEmployees() {
		Session session = sf.openSession();
		session.beginTransaction();
		Query<Employee> q1 = session.createQuery("from Employee", Employee.class); // Employee khong phai la ten table ma la ten Entity
		session.getTransaction().commit();
		List<Employee> employees = q1.list();
		session.close();
		return employees;
	}

	public Employee findById(int eid) {
		Session session = sf.openSession();
        session.beginTransaction();
        Employee employee = session.find(Employee.class, eid);
        session.getTransaction().commit();
        session.close();
		return employee;
	}

	public int deleteById(int eid) {
		Session session = sf.openSession();
        session.beginTransaction();
        NativeQuery<Employee> sql = session.createNativeQuery("delete from employee where eid = :eid", Employee.class);
        sql.setParameter("eid", eid);
        sql.executeUpdate();
        session.getTransaction().commit();
        session.close();
		return eid;
	}

	public void updateEmployee(Employee employee) {
		addEmployee(employee);
	}
}
