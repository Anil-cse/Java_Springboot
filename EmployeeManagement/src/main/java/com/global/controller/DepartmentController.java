package com.global.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.exception.IdNotFoundException;
import com.global.modal.Department;
import com.global.modal.Employee;
import com.global.repository.DepartmentRepo;
import com.global.repository.EmployeeRepo;

@RestController
public class DepartmentController {

	
	@Autowired
	DepartmentRepo departmentRepo;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	
	@PostMapping("/addDepartment")
	public Department addDepartment(@RequestBody Department department)
	{
		return departmentRepo.save(department);
	}
	
	@GetMapping("/EmployeeByDepartment/{dname}")
	public List<Employee> findByDepartment(@PathVariable String dname)
	{
		Department find = departmentRepo.findByDname(dname);
		if(find!=null)
		{
		List<Employee> employee = find.getEmployee();
		return employee;
		}
		else
		{
			throw new IdNotFoundException("department name not found");
		}
	}
	
	
	@PutMapping("/updateDepartment/{did}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable int did)
	{
		Optional<Department> find = departmentRepo.findById(did);
		if(find.isPresent())
		{
			Department fromRepo = find.get();
			fromRepo.setDname(department.getDname());
		    return departmentRepo.save(fromRepo);
		}
		else
		{
			throw new IdNotFoundException("department id not found");
		}
	}
	
	@GetMapping("/findAllDepartment")
	public List<Department> allDepartment()
	{
		return departmentRepo.findAll();
	}
	
	
	@DeleteMapping("/deleteDepartment/{did}")
	public String deleteDepartment(int did)
	{
		if(!departmentRepo.existsById(did))
		{
			throw new IdNotFoundException("department id not found for deletion");
		}
		departmentRepo.deleteById(did);
		return "department deleted successfully";
	}
}
