package com.demo;

import java.util.Scanner;

import com.demo.dto.student;
import com.demo.service.StudentDao;
import com.demo.serviceImpl.StudentImpl;

public class App {
	public static void main(String[] args) {
		int choice, num;

		StudentDao dao = new StudentImpl();
		student stu;

		do {
			System.out.println("<-------Menu------>");
			System.out.println("1.Add student ");
			System.out.println("2.Get studente by ID");
			System.out.println("3.Update student");
			System.out.println("4.Delete studnet by id");
			System.out.println("5.Get all student");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter  Details: ");
				System.out.println("Enter  ID: ");
				String id2 = sc.next();
				System.out.println("Enter Name: ");
				String name = sc.next();
				System.out.println("Enter address: ");
				String address = sc.next();
				System.out.println("Enter email: ");
				String email = sc.next();
				
				student e1 = new student(id2, name, address, email);
				stu = dao.addStudent(e1);
				break;

			case 2:
				
				stu= dao.getStudentById();
				break;

			case 3:
				System.out.println("Enter the Id to change record and update address: ");
				String id3 = sc.next();
				System.out.println("Enter the new address: ");
				String address1 = sc.next();
				stu = dao.updateStudent(id3, address1);
				break;

			case 4:
				System.out.println("Enter the ID to delete record");
				String id4 = sc.next();
				stu = dao.delStudent(id4);
				break;

			case 5:
				System.out.println("Student Data");

				// String newline = System.lineSeparator();
				// System.out.printf(" movieiD ", "movieName ", "language ","releasedIn ",
				// "revenueInDollars ");
				dao.getAllStudent();

				break;
			default:
				System.out.println("Wrong input..!");
				break;
			}
			System.out.println("   Enter 9 to continue..!");
			num = sc.nextInt();
		} while (num == 9);
	}
}
