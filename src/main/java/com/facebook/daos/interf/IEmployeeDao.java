package com.facebook.daos.interf;

import java.sql.SQLException;
import java.util.List;

import com.facebook.pojo.Employee;

public interface IEmployeeDao {

	public List<Employee> loginEmp(Employee emp) throws ClassNotFoundException, SQLException;

	public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException;
	
	void saveEmployee(Employee emp);
}
