package com.global.ParkingActivity3;


import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.global.ParkingActivity3.modal.Token;
import com.global.ParkingActivity3.modal.Vehicle;
import com.global.ParkingActivity3.service.ParkingService;



@Component
public class App {
    public static void main(String[] args) {
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ParkingService parkingLot = context.getBean(ParkingService.class);
    	
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 to park a vehicle, 2 to get total available empty slots, " +
                    "3 to get list of parked vehicles, or 4 to exit:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter vehicle ID:");
                   String vehicle_id = scanner.next();

                    System.out.println("Enter vehicle name:");
                    String vehicle_name = scanner.next();

                    System.out.println("Enter owner name:");
                    String owner_name = scanner.next();

                    Vehicle vehicle = new Vehicle(vehicle_id, vehicle_name, owner_name);
                    int token_id = parkingLot.parkVehicle(vehicle);

                    if (token_id == -1) {
                        System.out.println("No slots available.");
                    } else {
                        System.out.println("Vehicle parked. Token ID: " + token_id);
                    }
                    break;

                case 2:
                    int availableSlots = parkingLot.getAvailableSlots();
                    System.out.println("Available slots: " + availableSlots);
                    break;

                case 3:
                    List<Token> parkedVehicles = parkingLot.getParkedVehicles();

                    for (Token parkedVehicle : parkedVehicles) {
                        System.out.println("Token ID: " + parkedVehicle.getTokenId());
                        System.out.println("Vehicle ID: " + parkedVehicle.getVehicle().getVehicleId());
                        System.out.println("Vehicle name: " + parkedVehicle.getVehicle().getVehicleName());
                        System.out.println("Owner name: " + parkedVehicle.getVehicle().getOwnerName());
                        System.out.println("Check-in time: " + parkedVehicle.getCheckinTime());
                        System.out.println("Check-out time: " + parkedVehicle.getCheckoutTime());
                    }
                    break;

                case 4:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}

