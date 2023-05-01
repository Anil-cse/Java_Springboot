package com.global.dto;


import com.global.modal.Laptop;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDto {


	private int personId;
	private String name;
	//@JsonIgnore
	private Laptop laptop;
	
	
}