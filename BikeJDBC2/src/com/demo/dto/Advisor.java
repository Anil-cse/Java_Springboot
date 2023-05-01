package com.demo.dto;

public class Advisor {

	private String empId;
	private String empName;
	private String email;
	private String address;
	private String mobile;
	public Advisor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Advisor(String empId, String empName, String email, String address, String mobile) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Advisor [empId=" + empId + ", empName=" + empName + ", email=" + email + ", address=" + address
				+ ", mobile=" + mobile + "]";
	}
	
	
	
}
