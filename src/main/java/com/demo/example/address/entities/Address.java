package com.demo.example.address.entities;

import java.util.Date;

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
    
    
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getHousenumber() {
		return housenumber;
	}


	public void setHousenumber(int housenumber) {
		this.housenumber = housenumber;
	}


	public Address(AddressRequestDTO add) {
		this.state = add.state;
		this.city = add.city;
		this.housenumber = add.housenumber;
		
		
		
	}

}
