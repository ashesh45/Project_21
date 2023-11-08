package com.demo.example.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.example.security.entities.MyUserDetails;
import com.demo.example.users.entities.User;
import com.demo.example.users.repositories.UserRepository;



@Service
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
	
