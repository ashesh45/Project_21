package com.demo.example.address.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.demo.example.address.entities.Address;
import com.demo.example.address.entities.AddressResponseDTO;
import com.demo.example.helper.Helper;

public interface AddressService {
	 List<AddressResponseDTO> getAll();
	 Address persist(Address address);
	 
	
}
