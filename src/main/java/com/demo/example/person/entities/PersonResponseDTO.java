package com.demo.example.person.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import  com.fasterxml.jackson.annotation.JsonInclude.Include;
public interface PersonResponseDTO {
	
	    @JsonInclude(Include.NON_NULL)
	     String getName();
	    
	     @JsonInclude(Include.NON_NULL)
	     String getGender();

}
