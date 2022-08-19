package com.nagarro.application1.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.application1.dao.UserDao;
import com.nagarro.application1.entities.User;

@RestController
@CrossOrigin("*")
public class UserRestController {
	
	@Autowired
	private UserDao userDao;
	
	@GetMapping("/login/{username}")
	public Optional<User> getUser(@PathVariable String username) {
		return userDao.findById(username);
	}
	
	@PostMapping("/register")
	public User addUser(@RequestBody User user) {
		return userDao.save(user);
	}
}
