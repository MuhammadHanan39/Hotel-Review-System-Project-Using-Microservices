package com.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repository.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepo hotelRepo;
	
	
	
	
	
	@Override
	public List<Hotel> getAllHotels() {
		return this.hotelRepo.findAll();
	}

	
	@Override
	public Hotel saveHotel(Hotel hotel) {
		String hotelId=UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return this.hotelRepo.save(hotel);
	}

	
	@Override
	public Hotel getHotelById(String hotelId) {
		return this.hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with this id is not found"));
	}

	
	
	
	
	
}
