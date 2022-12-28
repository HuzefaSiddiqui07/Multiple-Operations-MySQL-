package com.multipleoperations.mysql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Select_EmpMain {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// pass the class name
		Query query = session.createQuery("from Employee");

		List<Employee> emp = query.list();

		for (Employee employee : emp) {

			System.out.println("Name > " + employee.getEmpName());
			System.out.println("Address > " + employee.getAddress());
			System.out.println("Gender > " + employee.getGender());
			System.out.println("E-Mail > " + employee.getEmail());
			System.out.println("Mobile Number > " + employee.getMobileNumber());

		}
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		System.out.println("Record Retrieved Successfully...");

	}

}
