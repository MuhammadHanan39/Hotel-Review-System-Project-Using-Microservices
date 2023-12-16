package com.user.service.controllers;

import java.util.List;

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

import com.user.service.entities.User;
import com.user.service.userservice.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;
	
	
	
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
		User u=this.userServiceImpl.getUser(userId);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}
	
	
	
	
	
	
}
