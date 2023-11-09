package com.demo.example.address.service;

import java.util.List;

import com.demo.example.address.entities.Address;
import com.demo.example.address.entities.AddressResponseDTO;

public interface AddressService {
	 List<AddressResponseDTO> getAll();
	 Address persist(Address address);
	 

}
