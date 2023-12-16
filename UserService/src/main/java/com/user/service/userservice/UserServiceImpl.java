package com.user.service.userservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repository.UserServiceRepo;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserServiceRepo userServiceRepo;
	
	
	
	@Override
	public User saveUser(User u) {
		return this.userServiceRepo.save(u);
		
	}

	@Override
	public List<User> getAllUser() {
		
		return this.userServiceRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		
		return this.userServiceRepo.findById(userId).orElseThrow(() -> 	new ResourceNotFoundException("User not found with user id" + userId));
	}

	
	
	
	
	
}
