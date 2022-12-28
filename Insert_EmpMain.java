package com.multipleoperations.mysql;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert_EmpMain {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		// insert data into database
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of employee details");
		int no = sc.nextInt();

		for (int a = 1; a <= no; a++) {

			System.out.println("Enter Name");
			String empName = sc.next();

			System.out.println("Enter Address");
			String address = sc.next();

			System.out.println("Enter Gender");
			String gender = sc.next();

			System.out.println("Enter E-Mail");
			String email = sc.next();

			System.out.println("Enter Mobile Number");
			String mobileNumber = sc.next();

			Employee emp = new Employee();

			emp.setEmpName(empName);
			emp.setAddress(address);
			emp.setGender(gender);
			emp.setEmail(email);
			emp.setMobileNumber(mobileNumber);

			session.save(emp);

		}
		t.commit();
		session.close();
		System.out.println("Record Saved Successfully...");

	}

}
