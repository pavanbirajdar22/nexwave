package com.hib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hib.hibfactory.HibSessionFactory;
import com.hib.model.Employee;

public class EmployeeDAO {
	public void save(Employee employee) {
		SessionFactory factory = HibSessionFactory.getSessionFactory();
		Session session = factory.openSession();
		session.getTransaction().begin();

		session.save(employee);

		session.getTransaction().commit();
		session.close();
	}
}
