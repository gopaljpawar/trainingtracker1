package com.hcl.employee_management.domain;


public class Employee {
	private Long id;
	private String employeeName;
	private String department;
	private String designation;
	private String phonenumber;
	private String email;
	public Employee(Long id, String employeeName, String department, String designation, String phonenumber,
			String email) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.department = department;
		this.designation = designation;
		this.phonenumber = phonenumber;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	


}