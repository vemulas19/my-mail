package com.facebook.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.facebook.daos.interf.IEmployeeDao;
import com.facebook.pojo.Employee;

public class EmployeeHiberDao implements IEmployeeDao{

	public void saveEmployee(Employee emp) {
		System.out.println("Entered saveEmployee :: EmployeeDao");
		try {
			Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
			SessionFactory sessionFactory=configuration.buildSessionFactory();
			Session session=sessionFactory.openSession();
			System.out.println("trying to save!!");
			session.save(emp);
			session.beginTransaction().commit();
			System.out.println("Done!!");
		} catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Exiting from saveEmployee :: EmployeeDao");
		//Database logic
	}

	public List<Employee> loginEmp(Employee emp) {
		System.out.println("Entered into loginEmp :: EmployeeHiberDao");
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Employee where mail=:mail AND password=:password");
		query.setParameter("mail", emp.getMail());
		query.setParameter("password", emp.getPassword());

		List<Employee> list = query.list();
		return list;
	}

	public List<Employee> getAllEmployees() {
		
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query queryAll = session.createQuery("from Employee");
		List<Employee> employeeList = queryAll.list();
		return employeeList;
	}
}
