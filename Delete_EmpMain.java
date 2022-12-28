package com.multipleoperations.mysql;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete_EmpMain {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// pass the class name and id for delete record
		// we use load or get () method to get the id from database.

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the I'd number to Delete Record");
		int idNum = scanner.nextInt();

		Employee employee = (Employee) session.load(Employee.class, idNum);

		session.delete(employee);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		System.out.println("Record Deleted Successfully...");

	}

}
