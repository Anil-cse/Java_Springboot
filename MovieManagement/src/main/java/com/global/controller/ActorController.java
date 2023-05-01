package com.global.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.modal.Actor;
import com.global.modal.Generes;
import com.global.modal.Movie;
import com.global.repository.GeneresRepo;
import com.global.service.ActorService;

@RestController
public class ActorController {

	@Autowired
	ActorService actorService;
	
	
	@GetMapping("/actor/{actorId}")
	public ResponseEntity<Actor> findActor(@PathVariable int actorId)
	{
		return new ResponseEntity<Actor>(actorService.findByActorId(actorId), HttpStatus.OK);
	}
	
	@GetMapping("/actor/birth/{birthYear}")
	public ResponseEntity<Set<Actor>> findActorByYear(@PathVariable int birthYear)
	{
		return new ResponseEntity<Set<Actor>>(actorService.findActorByYear(birthYear), HttpStatus.OK);
	}
	
	@GetMapping("/actor/endwith/{firstName}")
	public ResponseEntity<Set<Actor>> findActorByFirstName(@PathVariable String firstName)
	{
		return new ResponseEntity<Set<Actor>>(actorService.findByFirstName(firstName), HttpStatus.OK);
	}
	
	
}
