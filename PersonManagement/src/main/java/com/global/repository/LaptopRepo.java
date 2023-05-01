package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Laptop;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop, Integer> {

	Laptop findByName(String name);
	
}
