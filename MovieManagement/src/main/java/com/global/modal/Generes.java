package com.global.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Generes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int genId;
	private String name;
	
	@OneToMany(mappedBy = "generes")
//	@ManyToOne
//	@JoinColumn(name="id")
	@JsonIgnore
	private List<Movie> movie;
	
	
	
	
	public Generes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Generes(int genId, String name) {
		super();
		this.genId = genId;
		this.name = name;
	}
	public int getGenId() {
		return genId;
	}
	public void setGenId(int genId) {
		this.genId = genId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Movie> getMovie() {
		return movie;
	}
	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}
	
	
	
	
	
	
	
	
}
