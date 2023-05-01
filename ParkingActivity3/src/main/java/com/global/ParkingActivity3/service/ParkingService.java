package com.global.ParkingActivity3.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.global.ParkingActivity3.modal.Token;
import com.global.ParkingActivity3.modal.Vehicle;


@Component
public class ParkingService {
    private static final int MAX_SLOTS = 50;

    private List<Token> parkedVehicles;
    private int availableSlots;

    public ParkingService() {
        parkedVehicles = new ArrayList<Token>();
        availableSlots = MAX_SLOTS;
    }

    public int parkVehicle(Vehicle vehicle) {
        if (availableSlots == 0) {
            return -1; // No slots available
        }

        int token_id = MAX_SLOTS - availableSlots + 1;
        Date checkin_time = new Date();
        parkedVehicles.add(new Token(token_id, vehicle, checkin_time));
        availableSlots--;
        return token_id;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public List<Token> getParkedVehicles() {
        return parkedVehicles;
    }
}
