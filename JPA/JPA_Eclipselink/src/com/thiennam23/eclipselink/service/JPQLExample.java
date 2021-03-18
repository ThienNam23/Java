package com.thiennam23.eclipselink.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.thiennam23.eclipselink.entity.Employee;

public class JPQLExample {

	public static void ScalarandAggregateFunctions(EntityManagerFactory emfactory, EntityManager entitymanager) {
		// Scalar function
		Query query = entitymanager.createQuery("Select UPPER(e.ename) from Employee e");
		@SuppressWarnings("unchecked")
		List<String> list = query.getResultList();

		for (String e : list) {
			System.out.println("Employee NAME: " + e);
		}

		// Aggregate function
		Query query1 = entitymanager.createQuery("Select MAX(e.salary) from Employee e");
		Double result = (Double) query1.getSingleResult();
		System.out.println("Max Employee Salary: " + result);
	}

	public static void BetweenAndLikeFunctions(EntityManagerFactory emfactory, EntityManager entitymanager) {
		// Between
		Query query = entitymanager
				.createQuery("Select e " + "from Employee e " + "where e.salary " + "Between 30000 and 40000");

		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>) query.getResultList();

		for (Employee e : list) {
			System.out.print("Employee ID :" + e.getEid());
			System.out.println("\t Employee salary :" + e.getSalary());
		}

		// Like
		Query query1 = entitymanager.createQuery("Select e " + "from Employee e " + "where e.ename LIKE 'M%'");

		@SuppressWarnings("unchecked")
		List<Employee> list1 = (List<Employee>)query1.getResultList();

		for (Employee e : list1) {
			System.out.print("Employee ID :" + e.getEid());
			System.out.println("\t Employee name :" + e.getEname());
		}
	}

	public static void Ordering(EntityManagerFactory emfactory, EntityManager entitymanager) {
		// Ordering
		Query query = entitymanager.createQuery("Select e " + "from Employee e " + "ORDER BY e.ename ASC");

		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>)query.getResultList();

		for (Employee e : list) {
			System.out.print("Employee ID :" + e.getEid());
			System.out.println("\t Employee Name :" + e.getEname());
		}
	}

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Eclipselink");
		EntityManager entitymanager = emfactory.createEntityManager();

		// ScalarandAggregateFunctions(emfactory, entitymanager);
		BetweenAndLikeFunctions(emfactory, entitymanager);
//		Ordering(emfactory, entitymanager);
		entitymanager.close();
		emfactory.close();
	}
}
