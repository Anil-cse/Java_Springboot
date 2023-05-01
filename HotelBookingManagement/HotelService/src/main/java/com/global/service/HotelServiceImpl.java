package com.global.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.modal.Hotel;
import com.global.repository.HotelRepository;

@Service
public class HotelServiceImpl {
	
	@Autowired
	HotelRepository hotelRepository;

	public Hotel createHotel(Hotel hotel)
	{
		return hotelRepository.save(hotel);
	}
}
