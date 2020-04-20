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
import com.model.FourWheeler;
import com.model.TwoWheeler;
import com.model.Vehicle;	

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
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    emp1 = (Employee)session.get(Employee.class, 3);
	    
		session.getTransaction().commit();
		session.close();
		
		

		
		session = sessionFactory.openSession();
		session.beginTransaction();
	    session.update(emp1);
	    emp1.setEmployeeName("dummy");
	    emp1.setEmployeeName("dummy1");
		session.getTransaction().commit();
		session.close();
		
		sessionFactory.close();
		
	}

}
