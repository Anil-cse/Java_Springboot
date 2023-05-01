package com.demo.dto;

import java.util.Date;

public class Bike {
	private String bikeId;
	private String name;
	private String email;
	private String address;
	private String mobile;
	private String empId;
	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bike(String bikeId, String name, String email, String address, String mobile, String empId) {
		super();
		this.bikeId = bikeId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
		this.empId = empId;
	}

	public String getBikeId() {
		return bikeId;
	}
	public void setBikeId(String bikeId) {
		this.bikeId = bikeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "Bike [bikeId=" + bikeId + ", name=" + name + ", email=" + email + ", address=" + address + ", mobile="
				+ mobile + ", empId=" + empId + "]";
	}

	
}