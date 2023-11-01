package com.demo.example.person.service;

import java.util.List;

import com.demo.example.person.entities.Person;
import com.demo.example.person.entities.PersonResponseDTO;

public interface PersonService {
	
	List<PersonResponseDTO> getAll();
	Person persist(Person person);

}
