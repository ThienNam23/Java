package com.thiennam23.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.thiennam23.eclipselink.entity.Employee;

public class FindEmployee {
   public static void main(String[] args) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_Eclipselink");
      EntityManager entitymanager = emfactory.createEntityManager();
      Employee employee = entitymanager.find(Employee.class, 1201);

      System.out.println(employee);
      entitymanager.close();
      emfactory.close();
   }
}