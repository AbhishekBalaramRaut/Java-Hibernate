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
		int myValue = 4;

		// Create CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// Create CriteriaQuery
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> root = criteria.from(Employee.class);
		
		//criteria.select(root).where(builder.between(root.get("employeeId"), 4,6));
		criteria.select(root).where(builder.and(builder.greaterThan(root.get("employeeId"), 4), 
				builder.lessThan(root.get("employeeId"), 6)));

		Query<Employee> q=session.createQuery(criteria);
		
		List<Employee> emp = (List<Employee>) q.getResultList();
	    
		session.getTransaction().commit();
		session.close();
		
		for(Employee e: emp) {
			System.out.println("Emp name: "+e.getEmployeeName());
		}
		
		
		
		sessionFactory.close();
		
	}

}
