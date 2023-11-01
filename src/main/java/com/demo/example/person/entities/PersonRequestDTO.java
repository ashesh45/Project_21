package com.demo.example.person.entities;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonRequestDTO {
	
	
	@NotNull
	@JsonInclude
	@JsonProperty(value="name")
	String name;
	
	@JsonInclude
	@JsonProperty(value="gender")
	String gender;

}
