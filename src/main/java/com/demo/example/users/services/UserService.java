package com.demo.example.users.services;

import com.demo.example.users.entities.User;
import com.demo.example.users.entities.UserRequestDTO;

public interface UserService {
	User save(UserRequestDTO userRequest);


}
