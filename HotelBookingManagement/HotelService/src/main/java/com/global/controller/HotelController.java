package com.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.global.modal.Hotel;
import com.global.modal.RoomInfo;
import com.global.repository.HotelRepository;
import com.global.repository.RoomInfoRepository;
import com.global.service.HotelServiceImpl;

@RestController
public class HotelController {

	@Autowired
	HotelServiceImpl hotelService;


	
	@PostMapping("/createHotel")
	public Hotel addHotel(@RequestBody Hotel hotel)
	{
		return hotelService.createHotel(hotel);
	}

	
}
