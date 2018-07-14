package com.facebook.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Column(name="name")
	private String empName;
	@Column(name="mobile")
	private String mbl;
	
	@Id
	@Column(name="mail")
	private String mail;
	@Column(name="password")
	private String password;

	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getMbl() {
		return mbl;
	}
	public void setMbl(String mbl) {
		this.mbl = mbl;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
