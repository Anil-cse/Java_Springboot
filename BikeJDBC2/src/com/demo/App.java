package com.demo;

import java.util.Scanner;

import com.demo.dto.Advisor;
import com.demo.dto.Bike;


import com.demo.serviceImpl.BikeImpl;


public class App  {
	public static void main(String[] args) {
		int choice,num;
		
		BikeImpl dao = new BikeImpl();
		Bike bikeDto;
		Advisor advisor;
		
		do {
			System.out.println("\nMENU");
            System.out.println("1. Add Bike");
            System.out.println("2. Update Bike");
            System.out.println("3. Delete Bike");
            System.out.println("4. Add Service Advisor");
            System.out.println("5. Update Service Advisor");
            System.out.println("6. Delete Service Advisor");
            System.out.println("7. View Bikes");
            System.out.println("8. View Service Advisors");
            System.out.println("9. View Daily Service Report");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
		
		switch(choice)
		{
		case 1: System.out.println("Enter the ID of Contact: ");
				String bikeId = sc.next();
				bikeDto = dao.getBikeById(bikeId);
			break;
			
		case 2: System.out.println("Enter Bike Details: ");
				System.out.println("Enter Bike ID: ");
				String id2 = sc.next();
				System.out.println("Enter Bike Name: ");
				String name = sc.next();
				System.out.println("Enter email: ");
				String email = sc.next();
				System.out.println("Enter address: ");
				String address = sc.next();
				System.out.println("Enter mobile number: ");
				String mobile = sc.next();
				Bike e1 = new Bike(id2, name, email, address, mobile);
				bikeDto = dao.addBike(e1);
			break;
			
		case 3:	System.out.println("Enter the bikeId to change record and update: ");
				String id3 = sc.next();
				System.out.println("Enter the new address: ");
				String address1 = sc.next();
//				System.out.println("Enter the new mobile number: ");
//				String mobile1 = sc.next();
				bikeDto = dao.updateBike(id3, address1);
			break;
			
		case 4: System.out.println("Enter the contactID to delete record");
				String id4 = sc.next();
				bikeDto = dao.delBike(id4);
				break;
			
		case 5: System.out.println("contact information Data");
		
		        //String newline = System.lineSeparator();
				//System.out.printf("  movieiD  ", "movieName  ", "language  ","releasedIn  ", "revenueInDollars   ");
				dao.getAllBike();
				
				break;
		default:
			System.out.println("Wrong input..!"); 
			break;
		}
		System.out.println("   Enter 9 to continue..!");
		num = sc.nextInt();
		}while(num == 9);
	}
}
