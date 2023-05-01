package com.global.ParkingActivity3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.global.ParkingActivity3.service.ParkingService;

@Configuration
public class AppConfig {
    @Bean
    public ParkingService parkingLot() {
        return new ParkingService();
    }
}
