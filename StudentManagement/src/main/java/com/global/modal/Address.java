package com.global.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id
	private int addId;
	private String city;
	private String state;
	
	@ManyToOne
	private Student student1;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Student getStudent() {
		return student1;
	}

	public void setStudent(Student student1) {
		this.student1 = student1;
	}

	@Override
	public String toString() {
		return "Address [addId=" + addId + ", city=" + city + ", state=" + state + ", student1=" + student1 + "]";
	}
	
	

}
