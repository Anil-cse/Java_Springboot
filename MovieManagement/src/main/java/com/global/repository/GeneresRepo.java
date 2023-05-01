package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Generes;

@Repository
public interface GeneresRepo extends JpaRepository<Generes, Integer> {

	public Generes findByName(String name);
}
