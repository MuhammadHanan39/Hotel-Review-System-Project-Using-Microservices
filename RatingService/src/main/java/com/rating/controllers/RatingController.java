package com.rating.controllers;

 
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.http.HttpStatus; import
  org.springframework.http.ResponseEntity; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.PathVariable; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.RequestBody; import
  org.springframework.web.bind.annotation.RequestMapping; import
  org.springframework.web.bind.annotation.RestController;
  
  import com.rating.entities.Rating; import
  com.rating.service.RatingServiceImpl;
  
  @RequestMapping("/ratings")
  
  @RestController public class RatingController {
  
 @Autowired private RatingServiceImpl ratingServiceImpl;
  
  
  @GetMapping public ResponseEntity<List<Rating>> getAllRatings(){ return new
  ResponseEntity<List<Rating>>(this.ratingServiceImpl.getAllRating(),HttpStatus
  .OK); }
  
  @PostMapping public ResponseEntity<Rating> saveRating(@RequestBody Rating
  rating){ return new
  ResponseEntity<Rating>(this.ratingServiceImpl.CreateRating(rating),HttpStatus
  .CREATED); }
  
  
  @GetMapping("/user/{userId}") public ResponseEntity<List<Rating>>
  getRatingsByUserId(@PathVariable String userId){ return new
  ResponseEntity<List<Rating>>(this.ratingServiceImpl.getRatingsByUserId(userId
  ),HttpStatus.OK); }
  
  
  @GetMapping("/hotel/{hotelId}") public ResponseEntity<List<Rating>>
  getRatingsByHotelId(@PathVariable String hotelId){ return new
  ResponseEntity<List<Rating>>(this.ratingServiceImpl.getRatingsByHotelId(
  hotelId),HttpStatus.OK); }
  
  
  
  
  }
