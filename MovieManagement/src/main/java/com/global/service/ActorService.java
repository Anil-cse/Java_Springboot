package com.global.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.exception.IdNotFoundException;
import com.global.modal.Actor;
import com.global.repository.ActorRepo;

@Service
public class ActorService {

	@Autowired
	ActorRepo actorRepo;
	
	public Actor findByActorId(int actorId)
	{
		//return actorRepo.findById(actorId).get();
		Optional<Actor> fromRepo = actorRepo.findById(actorId);
		if(fromRepo.isPresent())
		{
			return fromRepo.get();
		}
		else
		{
			throw new IdNotFoundException("actor id not found");
		}
	}
	
	public Set<Actor> findActorByYear(int birthYear)
	{
		Set<Actor> fromRepo = actorRepo.findByBirthYearAfter(birthYear);
		if(fromRepo==null)
		{
			throw new IdNotFoundException("birthYear not found for actor");
		}
		return fromRepo;
	}
	
	public Set<Actor> findByFirstName(String firstName)
	{
		Set<Actor> fromRepo = actorRepo.findByFirstNameEndingWith(firstName);
		if(fromRepo==null)
		{
			throw new IdNotFoundException("ending with specified name not found");
		}
		else
		{
			return fromRepo;
		}
	}
	
}
