package com.glo;

import java.time.LocalDateTime;
import java.util.*;

import com.glo.modal.Token;
import com.glo.modal.Vehicle;

public class GloParking {
	private static final int TOTAL_SLOTS = 50;
	private static int nextTokenId = 1;
	private static List<Token> parkedVehicles = new ArrayList<>();

	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle("001", "Toyota Camry", "John Smith");
		Vehicle vehicle2 = new Vehicle("002", "Honda Civic", "Jane Doe");
		Vehicle vehicle3 = new Vehicle("003", "Ford Mustang", "Bob Johnson");
		Vehicle vehicle4 = new Vehicle("004", "Chevrolet Silverado", "Emily Brown");
		Vehicle vehicle5 = new Vehicle("005", "Tesla Model S", "Tom Davis");
		Token token1 = new Token(nextTokenId++, vehicle1, LocalDateTime.now());
		parkedVehicles.add(token1);
		Token token2 = new Token(nextTokenId++, vehicle2, LocalDateTime.now());
		parkedVehicles.add(token2);
		Token token3 = new Token(nextTokenId++, vehicle3, LocalDateTime.now());
		parkedVehicles.add(token3);
		Token token4 = new Token(nextTokenId++, vehicle4, LocalDateTime.now());
		parkedVehicles.add(token4);
		Token token5 = new Token(nextTokenId++, vehicle5, LocalDateTime.now());
		parkedVehicles.add(token5);
//		Vehicle vehicle5 = new Vehicle("005", "Tesla Model S", "Tom Davis");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1. Park a vehicle");
			System.out.println("2. Total available empty slots");
			System.out.println("3. List of parked vehicles");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				parkVehicle(scanner);
				break;
			case 2:
				showAvailableSlots();
				break;
			case 3:
				showParkedVehicles();
				break;
			case 4:
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}

	private static void parkVehicle(Scanner scanner) {
		if (parkedVehicles.size() >= TOTAL_SLOTS) {
			System.out.println("Sorry, all parking slots are occupied.");
			return;
		}

//		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter vehicle ID: ");
		String vehicleId = scanner.next();
		System.out.print("Enter vehicle name: ");
		String vehicleName = scanner.next();
		System.out.print("Enter owner name: ");
		String ownerName = scanner.next();

		Vehicle vehicle = new Vehicle(vehicleId, vehicleName, ownerName);

		Token token = new Token(nextTokenId++, vehicle, LocalDateTime.now());

		parkedVehicles.add(token);

		System.out.println("Vehicle parked successfully. Token ID: " + token.getTokenId());
	}

	private static void showAvailableSlots() {
		int availableSlots = TOTAL_SLOTS - parkedVehicles.size();
		System.out.println("Total available empty slots: " + availableSlots);
	}

	private static void showParkedVehicles() {
		if (parkedVehicles.isEmpty()) {
			System.out.println("No vehicles parked yet.");
			return;
		}

		System.out.printf("%-10s %-20s %-20s %-30s %-30s\n", "Token ID", "Vehicle ID", "Vehicle Name", "Owner Name",
				"Checkin Time");
		for (Token token : parkedVehicles) {
			System.out.printf("%-10d %-20s %-20s %-30s %-30s\n", token.getTokenId(), token.getVehicle().getVehicleId(),
					token.getVehicle().getVehicleName(), token.getVehicle().getOwnerName(), token.getCheckinTime());
		}
	}
}
