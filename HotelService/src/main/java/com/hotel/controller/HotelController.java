package com.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Hotel;
import com.hotel.service.HotelServiceImpl;

@RequestMapping("/hotel")
@RestController
public class HotelController {

	
	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
	
	//Method to get All hotels from database
	@GetMapping()
	public ResponseEntity<List<Hotel>> getAllHotelDetail(){	
		return new ResponseEntity<List<Hotel>>(this.hotelServiceImpl.getAllHotels(),HttpStatus.OK );
	}
	
	
	
	//Method to get Particular Hotel 
	@GetMapping("/{hotelId}")
	public Hotel getHotelById(@PathVariable String hotelId) {
		Hotel hotel=this.hotelServiceImpl.getHotelById(hotelId);
		return hotel;
	}
	
	
	//Method to save Hotel in database
	@PostMapping()
	public Hotel saveHotel(@RequestBody Hotel hotel) {		
		return this.hotelServiceImpl.saveHotel(hotel);
	
	}
	
	
	
}
