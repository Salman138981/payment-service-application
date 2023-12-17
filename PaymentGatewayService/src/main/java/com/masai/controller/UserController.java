package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.User;
import com.masai.service.UserService;

@RestController
public class UserController {
   
	  @Autowired
	    private UserService userService;

	    @PostMapping("/users")
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        User createdUser = userService.createUser(user);
	        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	    }

	    @GetMapping("/users")
	    public ResponseEntity<List<User>> getAllUsers() {
	        List<User> users = userService.getAllUsers();
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }

	    @GetMapping("/users/{userId}")
	    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
	        User user = userService.getUserById(userId);
	        return new ResponseEntity<>(user, HttpStatus.OK);
	    }

	    @DeleteMapping("/users/{userId}")
	    public ResponseEntity<User> deleteUser(@PathVariable("userId") Long userId) {
	        User deletedUser = userService.deleteUser(userId);
	        return new ResponseEntity<>(deletedUser, HttpStatus.OK);
	    }
}
