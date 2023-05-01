package com.global.modal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {

	@Id
	private int id;
	private String name;
	
	@OneToOne
	private Student student;


	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Laptop(int id, String name, Student student) {
		super();
		this.id = id;
		this.name = name;
		this.student = student;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "Laptop [id=" + id + ", name=" + name + ", student=" + student + "]";
	}
	
	
	
}
