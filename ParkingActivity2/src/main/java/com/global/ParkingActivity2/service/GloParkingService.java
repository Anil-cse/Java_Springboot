package com.global.ParkingActivity2.service;

import java.time.LocalDateTime;
import java.util.*;


import com.global.ParkingActivity2.modal.Token;
import com.global.ParkingActivity2.modal.Vehicle;

public class GloParkingService {

	
    private int totalSlots;
    
    public int getTotalSlots() {
		return totalSlots;
	}

	public void setTotalSlots(int totalSlots) {
		this.totalSlots = totalSlots;
	}

	private int usedSlots = 0;
    private List<Token> parkedVehicles = new ArrayList<Token>();
    private Scanner scanner = new Scanner(System.in);
    
    public void parkVehicle() {
        if (usedSlots >= totalSlots) {
            System.out.println("No available slots.");
            return;
        }
        
        System.out.println("Enter vehicle id:");
        String vehicleId = scanner.nextLine();
        System.out.println("Enter vehicle name:");
        String vehicleName = scanner.nextLine();
        System.out.println("Enter owner name:");
        String ownerName = scanner.nextLine();
        
        Vehicle vehicle = new Vehicle(vehicleId, vehicleName, ownerName);
        Token token = new Token(parkedVehicles.size() + 1, vehicle, LocalDateTime.now());
        parkedVehicles.add(token);
        usedSlots++;
        
        System.out.println("Vehicle parked. Token ID: " + token.getTokenId());
    }
    
    public void displayAvailableSlots() {
        int availableSlots = totalSlots - usedSlots;
        System.out.println("Available slots: " + availableSlots);
    }
    
    public void displayParkedVehicles() {
        System.out.println("Parked vehicles:");
        System.out.printf("%-10s %-15s %-20s %-20s\n", "Token ID", "Vehicle ID","Vehicle name", "Check-in Time");
        
        for (Token token : parkedVehicles) {
//            String checkOutTime = token.getCheckoutTime() != null ? token.getCheckoutTime().toString() : "N/A";
            System.out.printf("%-10d %-15s %-20s %-20s\n", token.getTokenId(), token.getVehicle().getVehicleId(),token.getVehicle().getVehicleName(),
                    token.getCheckinTime());
        }
    }
}
