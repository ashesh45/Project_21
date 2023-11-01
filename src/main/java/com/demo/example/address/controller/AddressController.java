package com.demo.example.address.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.address.entities.Address;
import com.demo.example.address.entities.AddressRequestDTO;
import com.demo.example.address.entities.AddressResponseDTO;
import com.demo.example.address.service.AddressService;
import com.demo.example.common.ApiResponse;



@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
	Logger logger = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("")
	public ApiResponse getAddresses(){
		ApiResponse  resp = new ApiResponse();
		List<AddressResponseDTO> address = addressService.getAll();
		resp.setResponseStatus("SUCCESS");
		resp.setDescription("List of Address");
		resp.setData(address);
		return resp;
	}
	
	@PostMapping("")
	public ApiResponse addAddresses(@Validated @RequestBody AddressRequestDTO addressDto){
		ApiResponse resp = new ApiResponse();
		logger.info(addressDto.toString());
		try {
			Address address = new Address(addressDto);
			address = addressService.persist(address);
			resp.setResponseStatus("SUCCESS");
			resp.setDescription("address saved to the database!");
			resp.setData(address);
		}catch (Exception e) {
			logger.error(e.getMessage());
			resp.setResponseStatus("Failure");
			resp.setDescription("address could not be saved to the database!");
		}
		return resp;
	}
	
}
