package com.demo.example.users.entities;

import org.antlr.v4.runtime.misc.NotNull;

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
public class UserRequestDTO {
	
	@NotNull
	@JsonProperty("username")
	String username;
	
	
	@NotNull
	@JsonProperty("password")
	String password;


}
