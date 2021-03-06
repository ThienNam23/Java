package com.thiennam23.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.thiennam23.eclipselink.entity.Employee;

public class DeleteEmployee {
   public static void main(String[] args) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Eclipselink");
      EntityManager entitymanager = emfactory.createEntityManager();
      entitymanager.getTransaction().begin();
      
      Employee employee = entitymanager.find(Employee.class, 1201);
      entitymanager.remove(employee);
      entitymanager.getTransaction().commit();
      entitymanager.close();
      emfactory.close();
   }
}