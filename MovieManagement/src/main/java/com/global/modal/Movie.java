package com.global.modal;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private int releasedYear;

	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Actor_TABLE",
            joinColumns = {
                    @JoinColumn(name = "actor_Id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "movie_Id")
            }
    )
	private Set<Actor> actor;
	
	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.MERGE)
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="id")
	private Generes generes;


	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(int id, String title, int releasedYear, Set<Actor> actor) {
		super();
		this.id = id;
		this.title = title;
		this.releasedYear = releasedYear;
		this.actor = actor;
	}

	public int getMovieId() {
		return id;
	}

	public void setMovieId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleasedYear() {
		return releasedYear;
	}

	public void setReleasedYear(int releasedYear) {
		this.releasedYear = releasedYear;
	}

	public Set<Actor> getActor() {
		return actor;
	}

	public void setActor(Set<Actor> actor) {
		this.actor = actor;
	}

	public Generes getGeneres() {
		return generes;
	}

	public void setGeneres(Generes generes) {
		this.generes = generes;
	}

	

	

	

	
	

}
