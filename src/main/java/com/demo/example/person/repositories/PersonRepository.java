package com.demo.example.person.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.example.person.entities.PersonResponseDTO;
import com.demo.example.person.entities.Person;


@Repository
public interface PersonRepository extends JpaRepository<Person ,Integer> {
	
	  PersonResponseDTO findbyName(String name);
	  
	  @Query(value = "select * from person", nativeQuery= true)
	  List<PersonResponseDTO> findALLName();
	  

}
