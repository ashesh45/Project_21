package com.demo.example.address.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public interface AddressResponseDTO {
	
	
	 @JsonInclude(Include.NON_NULL)
	 int getId();
	 
	 @JsonInclude(Include.NON_NULL)
	 String getState();
	 
	 @JsonInclude(Include.NON_NULL)
	 String getCity();
	 
	 @JsonInclude(Include.NON_NULL)
	 int getHousenumber();

}
