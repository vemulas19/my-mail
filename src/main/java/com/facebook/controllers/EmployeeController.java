package com.facebook.controllers;

import java.sql.SQLException;
import java.util.List;

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

import com.facebook.daos.EmployeeHiberDao;
import com.facebook.daos.interf.IEmployeeDao;
import com.facebook.pojo.Employee;
import com.facebook.pojo.Student;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeDao empDao;
	
	@Autowired
	private Student std1;
	
	@Autowired
	private Student std2;

	@RequestMapping(value = "/registerEmployee")
	public String saveEmployee(Employee emp) {
		System.out.println("Entered into saveEmployee :: EmployeeController");
		System.out.println("-----------------------------------------------------------");
		
		
		std1.setStdId(101);
		std1.setName("ragini");
		std1.setCollege("nmrg college");
		std1.setCourse("ECE");
		
		std2.setStdId(102);
		std2.setName("suchi");
		std2.setCollege("kits college");
		std2.setCourse("CSE");
		
		System.out.println(std1.getName() + "..." + std1.getCollege() + "..." + std1.getCourse() + "..." + std1.getStdId());
		
		System.out.println(std2.getName() + "..." + std2.getCollege() + "..." + std2.getCourse() + "..." + std2.getStdId());
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
