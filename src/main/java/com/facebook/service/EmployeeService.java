package com.facebook.service;

import com.facebook.daos.EmployeeHiberDao;
import com.facebook.pojo.Employee;
import com.facebook.validation.Validation;

public class EmployeeService {

	
	public String saveEmployee(Employee emp) {
		System.out.println(emp.getEmpName());
		System.out.println(emp.getMail());
		System.out.println(emp.getMbl());
		System.out.println(emp.getPassword());
		
		Validation val = new Validation();
		if(val.nullCheck(emp.getMail())) {
			return "Home";
		}
		
		EmployeeHiberDao dao = new EmployeeHiberDao();
		dao.saveEmployee(emp);
		return "login";
		
	}
	

	/*public String loginEmp(Employee emp, Model model) throws ClassNotFoundException, SQLException {
		System.out.println("Entered into loginEmp :: EmployeeService");
		System.out.println(emp.getMail());
		System.out.println(emp.getPassword());
		
		//Validation logic
		Validation val = new Validation();
		if(val.nullCheck(emp.getMail()) || val.nullCheck(emp.getPassword())) {
			model.addAttribute("message", "Username and password should not be empty or null");
			return "login";
		}
		
		// fetch data for mail and password
//		EmployeeHiberDao empHibernateDao = new EmployeeHiberDao();
//		EmployeeJdbcDao dao = new EmployeeJdbcDao();
		List<Employee> list = empHibernateDao.loginEmp(emp);

		//validate list
		if (list.isEmpty()) {
			model.addAttribute("invalid message");
			return "login";
		}

		//get all employees
		List<Employee> employeeList = empHibernateDao.getAllEmployees();
		
		model.addAttribute("empList", employeeList);
		for (Employee employee : employeeList) {
			System.out.println(employee.getMail() + "--" + employee.getEmpName() + "--" + employee.getMbl());
		}

		model.addAttribute("userName", emp.getMail());
		return "Profile";
	}*/
}
