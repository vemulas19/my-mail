package com.reg;

public class Employee {
	public static  int id;
	public String name;
	public String company;
	public double salary;
	
	public static void main(String[] args) {
		Employee emp1=new Employee();
		emp1.id=10;
		emp1.name="suresh";
		emp1.company="JDA";
		emp1.salary=30000;
		System.out.println(emp1);
		
	}
}
