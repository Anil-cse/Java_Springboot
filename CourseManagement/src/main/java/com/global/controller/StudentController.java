package com.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.modal.Student;
import com.global.repository.StudentRepo;
import com.global.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;

	
	@PostMapping("student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.OK);
	}

	@GetMapping("all")
	public ResponseEntity<List<Student>> getAll()
    {
        
        return new ResponseEntity<List<Student>>(studentService.getAll(), HttpStatus.OK);
    }
    
	@PutMapping("student/{studentId}")
	public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable int studentId)
	{
		return new ResponseEntity<Student>(studentService.updateStudent(student, studentId), HttpStatus.OK);
	}
}
