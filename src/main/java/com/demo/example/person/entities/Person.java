package com.demo.example.person.entities;

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
public class Person extends PersistenceEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String gender;
	
	public Person(PersonRequestDTO add) {
		// TODO Auto-generated constructor stub
		this.name = add.name;
		this.gender = add.gender;
	}

}
