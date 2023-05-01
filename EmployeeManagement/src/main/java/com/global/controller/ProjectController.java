package com.global.controller;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.global.exception.IdNotFoundException;
import com.global.modal.Employee;
import com.global.modal.Project;
import com.global.repository.EmployeeRepo;
import com.global.repository.ProjectRepo;

@RestController
public class ProjectController {

	
	@Autowired
	EmployeeRepo employeeRepo;
	
	
	@Autowired
	ProjectRepo projectRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@GetMapping("/AllProject/Employee/{eid}")
	public List<Project> findProjectByEmployeeId(@PathVariable int eid)
	{
		Optional<Employee> find = employeeRepo.findById(eid);
		if(find.isPresent())
		{
			Employee employee = find.get();
			List<Project> project = employee.getProject();
			return project;
		}
		else
		{
			throw new IdNotFoundException("employee id not found for project");
		}
	}
	
	@GetMapping("/AllEmployee/project/{pid}")
	public List<Employee> findAllEmployeeProject(@PathVariable int pid)
	{
		Optional<Project> find = projectRepo.findById(pid);
		if(find.isPresent())
		{
			Project project = find.get();
			List<Employee> employee = project.getEmployee();
			return employee;
		}
		else
		{
			throw new IdNotFoundException("project id not found for employee");
		}
	}
	

	@DeleteMapping("/delete/project/{pid}")
	public String deleteProject(@PathVariable int pid)
	{
		projectRepo.deleteById(pid);
		return "deleted success";
	}
	
	
	

}
