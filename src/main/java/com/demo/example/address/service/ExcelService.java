package com.demo.example.address.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.example.address.entities.Address;
import com.demo.example.address.repositories.AddressRepository;
import com.demo.example.helper.Helper;



public class ExcelService {
	
	@Autowired
	private AddressRepository repo;
	
	public ByteArrayInputStream getActualData() {
		List<Address> all=repo.findAll();
		  ByteArrayInputStream byteArrayInputStream=Helper.dataToExcel(all);
		  return byteArrayInputStream;
		
	}

}
