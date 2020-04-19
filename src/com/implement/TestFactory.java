package com.implement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.model.Address;
import com.model.Book;
import com.model.Employee;

public class TestFactory {

	public static void main(String[] args) {
		Book book  = new Book();
		
		book.setBookid("16");
		book.setBookname("Harry Potter 2");
		book.setAuthorid("rowling 1");
		Address a1 = new Address();
		a1.setState("Maharashtra");
		a1.setCity("Mumbai");
		a1.setStreet("rane street");
		
		Address a2 = new Address();
		a2.setState("Maharashtra");
		a2.setCity("Pune");
		a2.setStreet(" shaniwar peth");
		
		Employee emp1  = new Employee("Abhishek");
		emp1.setAddress(a1);
		emp1.setOfficeAddress(a2);
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(emp1);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
