package com.demo.example.address.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.example.address.entities.AddressResponseDTO;
import com.demo.example.address.entities.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
	
	
  AddressResponseDTO findbyName(String name);
	  
	  @Query(value = "select * from address", nativeQuery= true)
	  List<AddressResponseDTO> findALLAddress();
	  

}
