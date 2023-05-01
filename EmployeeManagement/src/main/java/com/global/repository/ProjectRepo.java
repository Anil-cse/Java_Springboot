package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.global.modal.Project;


@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

	Project findByPname(String pname);
	
}
