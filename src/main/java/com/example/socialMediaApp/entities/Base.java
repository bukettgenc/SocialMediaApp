package com.example.socialMediaApp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class Base {
	//Base'e idnin eklenmeme sebebi bazı tablolarda composite id olma ihtimali.

	@Column(name = "createdDate")
	private Date createdDate;

	@Column(name = "updatedDate")
	private Date updatedDate;

	@ManyToOne
	@JoinColumn(name = "created_user")
	private User createdUser;

	@ManyToOne
	@JoinColumn(name = "updated_user")
	private User updatedUser;

}
