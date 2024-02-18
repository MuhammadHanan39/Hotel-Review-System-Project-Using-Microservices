package com.user.service.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.service.entities.Hotel;
import com.user.service.entities.Rating;
import com.user.service.entities.User;
import com.user.service.external.service.HotelService;
import com.user.service.external.service.RatingService;
import com.user.service.userservice.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RestTemplate restTemplate;
	//Storing the user in the database
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(this.userServiceImpl.saveUser(user),HttpStatus.CREATED);
	}
	
	
	//Getting All the users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(this.userServiceImpl.getAllUser(),HttpStatus.OK);
	}
	
	
	
	
	
	//Getting user with specific Id
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		
		User user=this.userServiceImpl.getUser(userId);
		System.out.println("Get User Handler");
		
		
		
//		//Get the ratings of the particular user
//		ArrayList<Rating> ratings2 = this.restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user.getUserId(), ArrayList.class);
//		System.out.println(ratings2);
	
		
		
		List<Rating> ratings=(ArrayList<Rating>) this.ratingService.getAllRatings(user.getUserId());
		System.out.println("Hello ratings"+ratings);
		
		
		
		List<Rating> ratingsWithHotels= ratings.stream().map(rating ->{
			Hotel hotel= this.hotelService.getHotelWithId(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		
		System.out.println(ratingsWithHotels);
		
		
		//Set the ratings of the user
		user.setRatings(ratingsWithHotels);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
	
	
	
	
}
