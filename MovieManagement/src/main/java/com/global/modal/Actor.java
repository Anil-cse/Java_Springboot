package com.global.modal;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Actor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private int birthYear;
	
	@ManyToMany(mappedBy = "actor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JsonBackReference
	@JsonIgnore
    private Set<Movie> movie;
	
	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Actor(int id, String firstName, String lastName, int birthYear, Set<Movie> movie) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.movie = movie;
	}

	public int getActorId() {
		return id;
	}
	public void setActorId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public Set<Movie> getMovie() {
		return movie;
	}

	public void setMovie(Set<Movie> movie) {
		this.movie = movie;
	}
	
	
	
	
	
}
