package com.demo.example.common;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public class PersistenceEntity {
	
	@CreationTimestamp
	@Column(name="created_date")
	Date createdDate;
	
	@UpdateTimestamp
	@Column(name="last_updated_date")
	Date lastUpdatedDate;

}
