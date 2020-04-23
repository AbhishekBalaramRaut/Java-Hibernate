package com.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.query.Query;
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
		
		Query<String> query = session.getNamedNativeQuery("empBasedOnName");
		query.setParameter("emp", Integer.valueOf(myValue));
		List<String> empList = query.list();
	    
		session.getTransaction().commit();
		session.close();
		
		for(String e1 : empList) {
			System.out.println("Emp name: "+e1);
		}
		
		sessionFactory.close();
		
	}

}
