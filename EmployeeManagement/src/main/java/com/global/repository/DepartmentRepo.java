package com.global.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.modal.Department;


@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

	
	Department findByDname(String dname);
	
}
