package com.thiennam23.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.thiennam23.eclipselink.entity.Employee;

public class UpdateEmployee {
	public static void main(String[] args) {
		// Prepared
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Eclipselink");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Employee employee = entitymanager.find(Employee.class, 1201);

		// before update
		System.out.println(employee);
		employee.setSalary(46000);
		entitymanager.getTransaction().commit();

		// after update
		Employee employee2 = entitymanager.find(Employee.class, 1201);
		System.out.println(employee2);
		entitymanager.close();
		emfactory.close();
	}
}