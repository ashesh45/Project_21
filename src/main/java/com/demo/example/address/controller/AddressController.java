package com.demo.example.address.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
import com.demo.example.address.service.PdfService;
import com.demo.example.common.ApiResponse;

import jakarta.servlet.http.HttpServletResponse;



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
	public ApiResponse addAddresses(@Validated   @RequestBody AddressRequestDTO addressDto){
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
	
	
	@RequestMapping("/excel")
	public ResponseEntity<Resource> download(){
		
		String filename="address.xlsx";
		 ByteArrayInputStream actualData  =Service.getActualData();
		InputStreamResource file=new InputStreamResource(actualData);
		
		ResponseEntity<Resource> body = ResponseEntity.ok()
               .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+filename)
               	.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))	
                .body(file);
		
		
                return body;
	}
	

	@GetMapping("/createPdf")
	public ResponseEntity<InputStreamResource> createPdf() {
		
		ByteArrayInputStream pdf = pdfService.createPdf();
		
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("Content-Disposition","inline; filename=address.pdf");
		
		return ResponseEntity
				.ok()
				.headers(httpHeaders)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdf));
		
	}
	

}
