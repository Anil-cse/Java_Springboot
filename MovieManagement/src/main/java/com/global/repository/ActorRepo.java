package com.global.repository;



import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Actor;

@Repository
public interface ActorRepo extends JpaRepository<Actor, Integer>{

	Set<Actor> findByBirthYearAfter(int birthYear);
	
	Set<Actor> findByFirstNameEndingWith(String firstName);
	
}
