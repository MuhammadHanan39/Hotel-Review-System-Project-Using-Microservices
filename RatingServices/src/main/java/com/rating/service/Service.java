package com.rating.service;

import java.util.List;

import com.rating.entities.Rating;

public interface Service {

	
	public Rating CreateRating(Rating rating);
	
	public List<Rating> getAllRating();
	
	public List<Rating> getRatingsByUserId(String userId);
	
	public List<Rating> getRatingsByHotelId(String hotelId);
	
	
	
}
