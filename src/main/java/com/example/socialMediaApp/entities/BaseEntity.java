package com.example.socialMediaApp.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;


@Data
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private Date createdDate;
	
	private Date updatedDate;
	
	private User createdUser;
	
	private User updatedUser;
	
}
