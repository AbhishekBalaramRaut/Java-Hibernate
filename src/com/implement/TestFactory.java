package com.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.*;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.hibernate.Criteria;
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

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee emp = session.get(Employee.class, 1);
		
	    
		session.getTransaction().commit();
		session.close();
		
		
		 session = sessionFactory.openSession();
		 session.beginTransaction();
		Employee emp1 = session.get(Employee.class, 1);
	    
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Emp name: "+emp.getEmployeeName());
		
		
		
		
		sessionFactory.close();

		
	}

}
