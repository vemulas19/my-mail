package com.facebook.controllers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.facebook.pojo.Employee;

@Controller
public class EmployeeUpdate {

	@RequestMapping(value="/openInEditMode", method=RequestMethod.POST)
	public String openEditMode(@RequestParam("email") String mail, Model mode) {
		System.out.println("open in edit mode!! " + mail);
		Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Employee emp = (Employee) session.get(Employee.class, mail);
		mode.addAttribute("employee", emp);
		return "editview";
	}
}
