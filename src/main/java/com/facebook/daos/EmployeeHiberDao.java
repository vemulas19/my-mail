package com.facebook.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.facebook.controllers.EmployeeController;
import com.facebook.daos.interf.IEmployeeDao;
import com.facebook.pojo.Employee;

public class EmployeeHiberDao implements IEmployeeDao{
	
	final static Logger logger = Logger.getLogger(EmployeeHiberDao.class);

	public void saveEmployee(Employee emp) {
		logger.info("Entered saveEmployee :: EmployeeDao");
		try {
			Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
			SessionFactory sessionFactory=configuration.buildSessionFactory();
			Session session=sessionFactory.openSession();
			logger.info("trying to save!!");
			session.save(emp);
			session.beginTransaction().commit();
			logger.info("Done!!");
		} catch(Exception e) {
			logger.error("Exception occured while saving an employee", e);
		}
		logger.info("Exiting from saveEmployee :: EmployeeDao");
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
