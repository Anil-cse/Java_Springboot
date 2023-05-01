package com.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.modal.Passport;
import com.global.modal.Person;
import com.global.repository.PassportRepo;
import com.global.repository.PersonRepo;

@RestController
public class PersonController {

	@Autowired
	PersonRepo personRepo;
	
	@Autowired
	PassportRepo passportRepo;
	
	@PostMapping("/addPerson")
	public Person addPerson(@RequestBody Person person)
	{
		return personRepo.save(person);
	}
	
	@GetMapping("/allPerson")
	public List<Person> getAll()
	{
		List<Person> findAll = personRepo.findAll();
		return findAll;
	}
	
	@GetMapping("/person/{id}")
	public Person findById(@PathVariable int id)
	{
		return personRepo.findById(id).get();
	}

	
	@GetMapping("/findPersonByPassport/{pId}")
	public Person findPersonByPassport(int pId)
	{
		Passport passport = passportRepo.findById(pId).get();
		Person person = passport.getPerson();
		return person;
	}
	
	
	@PostMapping("/addPassport")
	public Passport addPassport(@RequestBody Passport passport)
	{
		return passportRepo.save(passport);
	}
	
	@PutMapping("/updatePerosn/{id}")
	public Person updatePerson(@RequestBody Person person, @PathVariable int id)
	{
		Person fromRepo = personRepo.findById(id).get();
		fromRepo.setName(person.getName());
		fromRepo.setAddress(person.getAddress());
		fromRepo.setPassport(person.getPassport());
		return personRepo.save(fromRepo);
		
	}
}
