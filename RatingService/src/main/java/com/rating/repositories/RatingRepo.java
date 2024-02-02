package com.rating.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rating.entities.Rating;

public interface RatingRepo extends MongoRepository<Rating, String>{

	public List<Rating> findByUserId(String userId);
	
	public List<Rating> findByHotelId(String hotelId);
	
	
}
