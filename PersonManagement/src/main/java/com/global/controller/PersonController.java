package com.global.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.dto.LaptopDto;
import com.global.dto.PersonDto;
import com.global.modal.Laptop;
import com.global.modal.Person;
import com.global.repository.LaptopRepo;
import com.global.repository.PersonRepo;

@RestController
public class PersonController {

	
	@Autowired
	PersonRepo personRepo;
	
	@Autowired
	LaptopRepo laptopRepo;
	
	@PostMapping("/addPerson")
	public Person addPerson(@RequestBody Person person)
	{
		return personRepo.save(person);
	}
	
	@GetMapping("/getPerson/{name}")
	public PersonDto getLaptop(@PathVariable String name)
	{
		Laptop laptop = laptopRepo.findByName(name);
		Person person = laptop.getPerson();
		PersonDto dto1 = new PersonDto();
		dto1.setPersonId(person.getPersonId());
		dto1.setName(person.getName());
		dto1.setLaptop(person.getLaptop());
		
	return dto1;
	}
	
	@GetMapping("/findAll")
	public List<PersonDto> findAllPerson()
	{
		List<Person> findAll = personRepo.findAll();
		
		List<PersonDto> list = findAll.stream().map(person -> this.toDto(person)).collect(Collectors.toList());
		
		return list;
		
	}
	
	@DeleteMapping("/deletePerson/{personId}")
	public String deletePerson(@PathVariable int personId)
	{
		personRepo.deleteById(personId);
		return "person and laptop deleted successfully";
	}
	
	
	public PersonDto toDto(Person person)
	{
		PersonDto dto = new PersonDto();
		dto.setPersonId(person.getPersonId());
		dto.setName(person.getName());
		//categoryDto to category
		Laptop lap = new Laptop();
		lap.setLaptopId(person.getLaptop().getLaptopId());
		lap.setName(person.getLaptop().getName());
		
		dto.setLaptop(lap);
		return dto;
	
}
}
