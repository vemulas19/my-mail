package com.facebook.jdbc.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.facebook.daos.interf.IEmployeeDao;
import com.facebook.pojo.Employee;

public class EmployeeJdbcDao implements IEmployeeDao {

	public List<Employee> loginEmp(Employee emp) throws ClassNotFoundException, SQLException {
		System.out.println("Entered into loginEmp :: EmployeeJdbcDao");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/spring","root", "ragini");
		PreparedStatement ps = conn.prepareStatement("select *from emloyee where mail = ? AND password = ?");
		ps.setString(1, emp.getMail());
		ps.setString(2, emp.getPassword());
		
		ResultSet rs = ps.executeQuery();
		List<Employee> empList = new ArrayList<Employee>();
		 while(rs.next()) {
			 Employee e = new Employee();
			 e.setMail(rs.getString("mail"));
			 e.setEmpName(rs.getString("name"));
			 e.setMbl(rs.getString("mobile"));
			 e.setPassword(rs.getString("password"));
			 empList.add(e);
		 }
		 System.out.println("Exit from loginEmp :: EmployeeJdbcDao");
		return empList;
	}

	public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException {
		System.out.println("Entered into getAllEmployees :: EmployeeJdbcDao");
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/spring","root", "ragini");
		PreparedStatement ps = conn.prepareStatement("select *from emloyee");
		
		ResultSet rs = ps.executeQuery();
		List<Employee> empList = new ArrayList<Employee>();
		 while(rs.next()) {
			 Employee e = new Employee();
			 e.setMail(rs.getString("mail"));
			 e.setEmpName(rs.getString("name"));
			 e.setMbl(rs.getString("mobile"));
			 e.setPassword(rs.getString("password"));
			 empList.add(e);
		 }
		 System.out.println("Exit from getAllEmployees :: EmployeeJdbcDao");
		return empList;
	}

	@Override
	public void saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
	}
}
