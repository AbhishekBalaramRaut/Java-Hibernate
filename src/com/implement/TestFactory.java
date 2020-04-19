package com.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
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

		
		Employee emp1  = new Employee();
		emp1.setEmployeeName("Abhishek");
		emp1.setJoiningDate(new Date());
		emp1.getAddressList().add(a1);
		emp1.getAddressList().add(a2);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(emp1);
		session.getTransaction().commit();
		session.close();
		
		
		 session = sessionFactory.openSession();
		session.beginTransaction();
		emp1 = (Employee) session.get(Employee.class, 1);
		session.getTransaction().commit();
		session.close();
		
		System.out.println(emp1.getAddressList().size());
		
		sessionFactory.close();
		
	}

}
