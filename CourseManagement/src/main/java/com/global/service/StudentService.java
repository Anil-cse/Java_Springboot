package com.global.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.modal.Student;
import com.global.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	StudentRepo studentRepo;
	
	public Student addStudent(Student student)
	{
		
		return studentRepo.save(student);
	}

	public List<Student> getAll()
    {
        List<Student> student = studentRepo.findAll();
        return student;
    }
	
	public Student updateStudent(Student student, int studentId)
	{
		Student fromRepo = studentRepo.findById(studentId).get();
		Student update = null;
		if(fromRepo!=null)
		{
			fromRepo.setName(student.getName());
			fromRepo.setAddress(student.getAddress());
			fromRepo.setCourse(student.getCourse());
			fromRepo.setProject(student.getProject());
			studentRepo.save(fromRepo);
			
		}
		
		return update;
	}
}
