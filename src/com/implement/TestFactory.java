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

		Employee emp = new Employee();
		emp.setEmployeeName("Abhi");
		emp.setJoiningDate(new Date());
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Employee where  employeeId  = :emp");
		query.setParameter("emp", 10);
		query.setCacheable(true);
		List<Employee> myList = query.list();
	   
		session.getTransaction().commit();
		session.close();
		
		
		 session = sessionFactory.openSession();
		 session.beginTransaction();
			 query = session.createQuery("from Employee where employeeId = :emp");
			 query.setCacheable(true);
			query.setParameter("emp", 10);
			
			myList = query.list();
			
	    
		session.getTransaction().commit();
		session.close();
				
		sessionFactory.close();

		
	}

}
