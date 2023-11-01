package com.demo.example.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.users.entities.UserRequestDTO;
import com.demo.example.users.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@PostMapping("")
	public String addUser(@Validated @RequestBody UserRequestDTO userRequest) {
		System.err.println(userRequest);
		return "Users created";
	}	

}
