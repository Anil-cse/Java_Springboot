package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
