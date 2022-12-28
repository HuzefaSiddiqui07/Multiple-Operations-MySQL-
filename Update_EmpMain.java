package com.multipleoperations.mysql;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Update_EmpMain {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// pass the class name and id for updating record
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the I'd Number");
		int idNumber = scanner.nextInt();

		System.out.println("Enter Name");
		String empName = scanner.next();

		System.out.println("Enter Address");
		String address = scanner.next();

		System.out.println("Enter Gender");
		String gender = scanner.next();

		System.out.println("Enter E-Mail");
		String email = scanner.next();

		System.out.println("Enter Mobile Number");
		String mobileNumber = scanner.next();

		Employee employee = (Employee) session.get(Employee.class, idNumber);

		employee.setEmpName(empName);
		employee.setAddress(address);
		employee.setGender(gender);
		employee.setEmail(email);
		employee.setMobileNumber(mobileNumber);

		session.update(employee);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		System.out.println("Record Updated Successfully...");

	}

}
