package com.demo.example.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.users.entities.User;
import com.demo.example.users.repositories.UserRepository;


@RestController
@RequestMapping("api/v1")
public class MyController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>This is admin's page</h1>";
	}
	@GetMapping("/user")
	public String user() {
		return "<h1>This is user's page</h1>";
	}
	
	@GetMapping("/addusers")
	public String addUser() {
		userRepo.save(new User(1, "ajay", passwordEncoder.encode("password"), "ROLE_ADMIN", true));
		userRepo.save(new User(2, "ashesh", passwordEncoder.encode("password"), "ROLE_USER", true));
		return "Users created";
	}
}

