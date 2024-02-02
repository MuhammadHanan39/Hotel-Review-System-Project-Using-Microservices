package com.hotel.service;

import java.util.List;

import com.hotel.entity.Hotel;

public interface HotelService {

	
	public List<Hotel> getAllHotels();
	
	public Hotel saveHotel(Hotel hotel);
	
	public Hotel getHotelById(String hotelId);
	
	
	
	
}
