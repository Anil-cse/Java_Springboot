package com.global.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.modal.Employee;
import com.global.modal.Project;
import com.global.repository.EmployeeRepo;
import com.global.repository.ProjectRepo;

@RestController
public class ProjectController {

	@Autowired
	ProjectRepo projectRepo;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@PostMapping("/createProject")
	public ResponseEntity<Project> addProject(@RequestBody Project project)
	{
	
		return new ResponseEntity<Project>(projectRepo.save(project), HttpStatus.OK);
	}
	
	@GetMapping("/allProject")
	public ResponseEntity<List<Project>> getAllProject()
	{
		return new ResponseEntity<List<Project>>(projectRepo.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
	{
	
		return new ResponseEntity<Employee>(employeeRepo.save(employee), HttpStatus.OK);
	}
	
	@GetMapping("/allEmployee")
	public ResponseEntity<List<Employee>> findEmployee()
	{
		return new ResponseEntity<List<Employee>>(employeeRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/project/allEmployee/{id}")
	public ResponseEntity<List<Employee>> getAllEmployee(Long id)
	{
		Project project = projectRepo.findById(id).get();
		List<Employee> employees = project.getEmployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@PutMapping("/project/update/{pId}")
	public ResponseEntity<Project> updateProject(@RequestBody Project project, @PathVariable Long pId)
	{
		Optional<Project> fromRepo = projectRepo.findById(pId);
		Project save=null;
		if(fromRepo.isPresent())
		{
			Project fromDb = fromRepo.get();
			fromDb.setName(project.getName());
			fromDb.setDescription(project.getDescription());
			fromDb.setEmployees(project.getEmployees());
			save = projectRepo.save(fromDb);
		}
		return new ResponseEntity<Project>(save,HttpStatus.OK);
		
	}
	
	@DeleteMapping("project/{id}")
	public ResponseEntity<String> deleteProject(Long id)
	{
		projectRepo.deleteById(id);
		return new ResponseEntity<String>("deleted project successfully", HttpStatus.OK);
	}
}
