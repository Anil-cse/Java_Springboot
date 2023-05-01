package com.global.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.modal.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	Employee findByEname(String ename);
	
	
	@Query("SELECT e FROM Employee e JOIN e.department d WHERE d.dname = :name")
	List<Employee> findEmployeesInITDepartment(@Param("name") String dname);
}
