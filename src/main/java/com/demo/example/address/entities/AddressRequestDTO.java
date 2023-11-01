package com.demo.example.address.entities;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressRequestDTO {
	
	@NotNull
	@JsonInclude(Include.NON_NULL)
	@JsonProperty(value="state")
	String state;
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty(value = "city")
	String city;
	
	
	@JsonInclude(Include.NON_NULL)
	@JsonProperty(value = "housenumber")
	int housenumber;

}
