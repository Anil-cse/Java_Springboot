package com.global;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.global.modal.Address;
import com.global.modal.Laptop;
import com.global.modal.Student;
import com.global.repository.LaptopRepository;
import com.global.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(StudentManagementApplication.class);
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	LaptopRepository laptopRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1 adding one to one :");
		System.out.println("2 fetch data :");
		System.out.println("3 one to many relation");
		int ch = sc.nextInt();
		
		if(ch==1)
		{
		Student student = new Student();
		student.setId(10);
		student.setName("Anil");
		student.setAbout("java developer");
		
		
		Laptop laptop = new Laptop();
		laptop.setId(1);
		laptop.setName("dell");
		
		laptop.setStudent(student);
		student.setLaptop(laptop);
		
		studentRepository.save(student); 
		}
		
		if(ch==2)
		{
		//student detail one to one
		Student student = studentRepository.findById(10).get();
		logger.info("student details : {},{}",student.getName(),student.getAbout());
		Laptop laptop = student.getLaptop();
		logger.info("laptop details :{}",laptop.getName());
		}
		
		if(ch==3)
		{
			Student student = new Student();
			student.setId(11);
			student.setName("amit");
			student.setAbout("pyhton developer");
			
			Address add1 = new Address();
			add1.setAddId(21);
			add1.setCity("varanasi");
			add1.setState("Uttar Pradesh");
			add1.setStudent(student);
			Address add2 = new Address();
			add2.setAddId(22);
			add2.setCity("Lucknow");
			add2.setState("Uttar Pradesh");
			add2.setStudent(student);
			
			List<Address> list = new ArrayList<>();
			list.add(add1);
			list.add(add2);
			
			student.setAddress(list);
			studentRepository.save(student);
			
			
			
			
		}
		if(ch==4)
		{
		}
		
		
		
		
		
		//studentRepository.deleteById(10);
		
		//logger.info("student details deleted: {}");
	}

}
