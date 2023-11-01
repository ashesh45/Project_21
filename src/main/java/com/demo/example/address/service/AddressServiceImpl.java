package com.demo.example.address.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.address.entities.Address;
import com.demo.example.address.entities.AddressResponseDTO;
import com.demo.example.address.repositories.AddressRepository;
@Service
public class AddressServiceImpl implements AddressService {

	
	@Autowired
	AddressRepository addressRepo;
	
	@Override
	public List<AddressResponseDTO> getAll() {
		// TODO Auto-generated method stub
		return addressRepo.findALLAddress();
	}

	@Override
	public Address persist(Address address) {
		// TODO Auto-generated method stub
		return addressRepo.save(address);
	}

}
