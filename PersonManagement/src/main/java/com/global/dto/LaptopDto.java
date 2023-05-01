package com.global.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.global.modal.Person;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class LaptopDto {

	
	private int laptopId;
	private String name;
	
	@JsonIgnore
	private Person person;
}
