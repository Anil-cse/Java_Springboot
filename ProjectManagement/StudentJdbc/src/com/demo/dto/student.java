package com.demo.dto;



public class student {
	private String studentId;
	private String studentName;
	private String studentAddress;
	private String email;
	public student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public student(String studentId, String studentName, String studentAddress, String email) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.email = email;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "student [studentId=" + studentId + ", studentName=" + studentName + ", studentAddress=" + studentAddress + ", email="
				+ email + "]";
	}
	
	
	
}
