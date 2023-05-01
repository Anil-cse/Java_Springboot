package com.global.ParkingActivity2;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.global.ParkingActivity2.service.GloParkingService;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("parking.xml");
        GloParkingService gloParkingService = context.getBean("gloParkingService", GloParkingService.class);
        
       
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to park a vehicle, 2 to display available slots, 3 to display parked vehicles, or 4 to exit:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    gloParkingService.parkVehicle();
                    break;
                case 2:
                    gloParkingService.displayAvailableSlots();
                    break;
                case 3:
                    gloParkingService.displayParkedVehicles();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

