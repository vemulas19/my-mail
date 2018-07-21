package com.facebook.controllers;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.facebook.daos.interf.IEmployeeDao;
import com.facebook.log4j.Test;
import com.facebook.pojo.Employee;
import com.facebook.pojo.Student;

@Controller
public class EmployeeController {

	final static Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	private IEmployeeDao empDao;

	@Autowired
	private Student std1;

	@Autowired
	private Student std2;

	@RequestMapping(value = "/registerEmployee")
	public String saveEmployee(Employee emp) {
		logger.info("Entered into saveEmployee :: EmployeeController");
		logger.info("-----------------------------------------------------------");

		std1.setStdId(101);
		std1.setName("ragini");
		std1.setCourse("ECE");
		std1.getPpt().setPptId(12654);

		std2.setStdId(102);
		std2.setName("suchi");
		std2.setCourse("CSE");
		std2.getPpt().setPptId(4532);

		
		
		logger.info(std1.getName() + "..." + std1.getCollege() + "..." + std1.getCourse() + "..."
				+ std1.getStdId() + "---" + std1.getPpt().getPptId() + "---" + std1.getPpt().getCity());

		logger.info(std2.getName() + "..." + std2.getCollege() + "..." + std2.getCourse() + "..."
				+ std2.getStdId() + "---" + std2.getPpt().getPptId() + "---" + std2.getPpt().getCity());
		
		logger.info("#####################################33");
		logger.debug(std1.getCites());
		logger.debug(std2.getCites());
		logger.info("#####################################33");
		if(emp.getMail() == null) {
			logger.debug("Mail id is null!!");
			return "Home";
		}
		
		empDao.saveEmployee(emp);
		return "login";

	}

	@RequestMapping(value = "/loginEmployee", method = RequestMethod.POST)
	public String loginEmp(Employee emp, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("Entered into loginEmp :: EmployeeService");
		System.out.println(emp.getMail());
		System.out.println(emp.getPassword());

		// Validation logic
		/*
		 * Validation val = new Validation(); if(val.nullCheck(emp.getMail()) ||
		 * val.nullCheck(emp.getPassword())) { model.addAttribute("message",
		 * "Username and  empty or null"); return "login"; }
		 * 
		 */
		// EmployeeJdbcDao dao = new EmployeeJdbcDao();
		List<Employee> list = empDao.loginEmp(emp);

		if (list.isEmpty()) {
			model.addAttribute("Invalid message");
			return "login";
		}

		// get all employees
		List<Employee> employeeList = empDao.getAllEmployees();

		model.addAttribute("empList", employeeList);
		for (Employee employee : employeeList) {
			System.out.println(employee.getMail() + "--" + employee.getEmpName() + "--" + employee.getMbl());
		}

		model.addAttribute("userName", emp.getMail());
		return "Profile";
	}

	@RequestMapping(value = "/deleteEmployee")
	public String deleteEmp(@RequestParam("mail") String email, Model model) {
		System.out.println("Mail is : " + email);

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("delete from Employee where mail=:mail");
		query.setParameter("mail", email);

		int result = query.executeUpdate();
		session.beginTransaction().commit();
		System.out.println("------" + result);

		Query queryAll = session.createQuery("from Employee");
		List<Employee> employeeList = queryAll.list();
		model.addAttribute("empList", employeeList);

		return "Profile";
	}
}
