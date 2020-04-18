package com.implement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.model.Book;
import com.model.Employee;

public class TestFactory {

	public static void main(String[] args) {
		Book book  = new Book();
		
		book.setBookid("16");
		book.setBookname("Harry Potter 2");
		book.setAuthorid("rowling 1");
		
		Employee emp1  = new Employee("Abhishek");

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(emp1);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
