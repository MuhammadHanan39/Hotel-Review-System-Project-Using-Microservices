package com.user.service.userservice;

import java.util.List;

import com.user.service.entities.User;

public interface UserService {

	
	//Method for save user
	public User saveUser(User u);
	
	//Method for get all users
	public List<User> getAllUser();
	
	//Method for get a particular user
	public User getUser(String userId);
	
	
	
	
}
