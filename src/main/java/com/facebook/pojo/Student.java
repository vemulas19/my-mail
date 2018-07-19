package com.facebook.pojo;

import java.util.List;

public class Student {

	private int stdId;
	private String name;
	private String course;
	private String college;
	private Passport ppt;
	private List<String> cites;
	
	Student() {
		
	}
	
	public Student(String college, String course) {
		this.college = college;
		this.course = course;
	}

	public Student(String college) {
		this.college = college;
	}
	
	public Student(Passport ppt) {
		this.ppt = ppt;
	}
	
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public Passport getPpt() {
		return ppt;
	}
	public void setPpt(Passport ppt) {
		this.ppt = ppt;
	}

	public List<String> getCites() {
		return cites;
	}

	public void setCites(List<String> cites) {
		this.cites = cites;
	}
	
}
