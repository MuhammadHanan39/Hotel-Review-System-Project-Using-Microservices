package com.user.service.userservice;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.entities.User;
import com.user.service.exceptions.ResourceNotFoundException;
import com.user.service.repository.UserServiceRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserServiceRepo userServiceRepo;
	
	
	
	@Override
	public User saveUser(User u) {	
		String userId=UUID.randomUUID().toString();
		System.out.println(userId);
		u.setUserId(userId);
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
