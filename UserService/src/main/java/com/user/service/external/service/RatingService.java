package com.user.service.external.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.entities.Rating;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	
	
	@GetMapping("/ratings/user/{userId}")
	public ArrayList<Rating> getAllRatings(@PathVariable String userId);
	
	
	
	

}
