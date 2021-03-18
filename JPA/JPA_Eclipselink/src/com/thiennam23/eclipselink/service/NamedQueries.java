package com.thiennam23.eclipselink.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.thiennam23.eclipselink.entity.Employee;

public class NamedQueries {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Eclipselink");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("find employee by id");

		query.setParameter("idpara", 1204);
		
		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>)query.getResultList();

		for (Employee e : list) {
			System.out.print("Employee ID :" + e.getEid());
			System.out.println("\t Employee Name :" + e.getEname());
		}
	}
}