package com.demo.example.address.entities;

import com.demo.example.common.PersistenceEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address extends PersistenceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String state;
	private String city;
    private int housenumber;
	
	public Address(AddressRequestDTO add) {
		this.state = add.state;
		this.city = add.city;
		this.housenumber = add.housenumber;
		
		
		
	}


}
