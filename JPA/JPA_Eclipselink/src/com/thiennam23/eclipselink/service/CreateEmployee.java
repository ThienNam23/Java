package com.thiennam23.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.thiennam23.eclipselink.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		// Prepared
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Eclipselink");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Employee employee = new Employee();
		employee.setEid(1203);
		employee.setEname("EF");
		employee.setSalary(10000);
		employee.setDeg("Product Manager");

		System.out.println("Start Persisting!");
		entitymanager.persist(employee);
		System.out.println("Persisted!");
		entitymanager.getTransaction().commit();
		System.out.println("Committed!");

		entitymanager.close();
		System.out.println("Entity Manager close!");
		emfactory.close();
		System.out.println("Entity Manager Factory close!");
		System.out.println("Goodbye!");
	}
}