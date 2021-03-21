package com.thiennam23.JPA_Hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.thiennam23.JPA_Hibernate.model.Student;
import com.thiennam23.JPA_Hibernate.model.Book;

public class ManyToManyExample {
	public static void putStudent(Session session) {

		Transaction transaction = session.beginTransaction();
		Book b1 = new Book(1300, "The Walking Dead");
		Book b2 = new Book(1301, "The Void");
		List<Book> books = Arrays.asList(b1, b2);

		Student st1 = new Student(1400, "Thien Nam");
		st1.setBooks(books);
		Student st2 = new Student(1401, "Starlist");
		st2.setBooks(Arrays.asList(b2));
		List<Student> students = Arrays.asList(st1, st2);

		b1.setStudents(Arrays.asList(st1));
		b2.setStudents(students);

		session.save(b1);
		session.save(b2);
		session.save(st1);
		session.save(st2);

		transaction.commit();
	}
/**
 * Danger
 * @param args
 */
//	public static void getStudent(Session session) {
//		Transaction transaction = session.beginTransaction();
//		Student student = new Student();
//		student = (Student) session.get(Student.class, 1401);
//		transaction.commit();
//		System.out.println(student);
//	}

	public static void main(String[] args) {

		Configuration config = new Configuration().configure("hibernate_manytomany.cfg.xml")
				.addAnnotatedClass(Student.class).addAnnotatedClass(Book.class);

		// ServiceRegistry registry = new
		// StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		// SessionFactory sf = config.buildSessionFactory(registry);

		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();

		// some methods
		putStudent(session);
//		getStudent(session);
	}
}
