package com.demo.example.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demo.example.users.entities.User;
import com.demo.example.users.repositories.UserRepository;
import com.example.spring.MyUserDetails;

public class MyUserDetailsService implements UserDetailsService {
    
	@Autowired
	UserRepository userRepo;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUsername(username);
		if(user.isEmpty()) {
			throw new UsernameNotFoundException(username+" not found in the database!");
		}
		return user.map(MyUserDetails::new).get();
	}
}
	
