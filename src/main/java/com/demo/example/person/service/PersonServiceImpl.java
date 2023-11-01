package com.demo.example.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.person.entities.Person;
import com.demo.example.person.entities.PersonResponseDTO;
import com.demo.example.person.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {
           
	@Autowired
	PersonRepository personRepo;
	 
	@Override
	public List<PersonResponseDTO> getAll() {
		// TODO Auto-generated method stub
		return personRepo.findALLName();
	}

	@Override
	public Person persist(Person person) {
		// TODO Auto-generated method stub
		return personRepo.save(person);
	}
	
	
	

}
