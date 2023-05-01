package com.global.modal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Account {

	@Id
	private Long accountNum;
	private String name;
	private String ifsc;
	
	@ManyToOne
	@JoinColumn(name="cId")
	//@JsonIgnore
	@JsonBackReference
	private Customer customer;
}
