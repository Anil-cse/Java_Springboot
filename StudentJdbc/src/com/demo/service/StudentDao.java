package com.demo.service;

import com.demo.dto.student;

public interface StudentDao {
	public student addStudent(student stu);
	
	public void getAllStudent();
	public student getStudentById();
	
	public student delStudent(String studentId);
	public student updateStudent(String studentId, String studentAddress);
	
}

