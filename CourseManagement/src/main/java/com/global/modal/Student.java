package com.global.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	private int studentId;
	private String name;
	private String address;
	
//	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//	private List<Course> course;
//	
//	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
//	private FinalProject project;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private List<Course> course;

    @OneToOne(cascade = CascadeType.ALL)
    private FinalProject project;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	public FinalProject getProject() {
		return project;
	}
	public void setProject(FinalProject project) {
		this.project = project;
	}
	
	

}
