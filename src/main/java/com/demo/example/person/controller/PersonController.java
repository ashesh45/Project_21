package com.demo.example.person.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.common.ApiResponse;
import com.demo.example.person.entities.Person;
import com.demo.example.person.entities.PersonRequestDTO;
import com.demo.example.person.entities.PersonResponseDTO;
import com.demo.example.person.service.PersonService;



@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
	Logger logger = LoggerFactory.getLogger(PersonController.class);
	    
	
	   @Autowired
	   PersonService personService;
	   
	public ApiResponse getPerson() {
		ApiResponse resp = new ApiResponse();
		List<PersonResponseDTO> persons = personService.getAll();
         resp.setResponseStatus("SUCCESS");
         resp.setDescription("List of Person");
         resp.setData(persons);
         return resp;
}
	

	@PostMapping("")
	public ApiResponse addAuthor(@Validated @RequestBody PersonRequestDTO personDto){
		ApiResponse resp = new ApiResponse();
		logger.info(personDto.toString());
		try {
			Person person = new Person(personDto);
			person = personService.persist(person);
			resp.setResponseStatus("SUCCESS");
			resp.setDescription("Person saved to the database!");
			resp.setData(person);
		}catch (Exception e) {
			logger.error(e.getMessage());
			resp.setResponseStatus("Failure");
			resp.setDescription("Person could not be saved to the database!");
		}
		return resp;
	}
}
