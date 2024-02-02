package com.rating.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.rating.entities.Rating;
import com.rating.repositories.RatingRepo;



@org.springframework.stereotype.Service
public class RatingServiceImpl implements RatingService{
	
	
	@Autowired
	private RatingRepo ratingRepo;
	
	
	
	

	@Override
	public Rating CreateRating(Rating rating) {
		return this.ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		return this.ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		return this.ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingsByHotelId(String hotelId) {
		return this.ratingRepo.findByHotelId(hotelId);
	}

}
