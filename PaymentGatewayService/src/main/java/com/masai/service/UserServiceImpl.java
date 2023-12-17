package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserException;
import com.masai.model.Payment;
import com.masai.model.User;
import com.masai.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
   
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		 if(user==null) throw new UserException("User is null");
		 
		 
		return userRepository.save(user);
		 
	}

	
	@Override
	public List<User> getAllUsers() {
		
		List<User> users = userRepository.findAll();
		
		if(users.isEmpty()) {
			throw new UserException("User List is Empty");
		}
		
		return users;
	}

	@Override
	public User getUserById(Long userId) {
		
		Optional<User> op =userRepository.findById(userId);
		
		if(op.isPresent()) {
			User user = op.get();
			return user;
		}else {
			throw new UserException("Invalid User Id");
		}
	}

	
	@Override
	public User deleteUser(Long userId) {
		Optional<User> op =userRepository.findById(userId);
		if(op.isPresent()) {
			User user = op.get();
			
			
			userRepository.delete(user);
			return user;
		}else {
			throw new UserException("Invalid User Id");
		}
	}

}
