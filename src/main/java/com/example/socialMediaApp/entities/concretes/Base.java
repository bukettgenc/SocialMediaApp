package com.example.socialMediaApp.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
@MappedSuperclass
public class Base {

	// Base'e idnin eklenmeme sebebi bazı tablolarda composite id olma ihtimali.

	@Column(name = "created_date")
	@CreatedDate
	@CreationTimestamp
	@NotNull
	@NotBlank
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@Column(name = "updated_date")
	@UpdateTimestamp
	@NotNull
	@NotBlank
	@Temporal(TemporalType.DATE)
	private Date updatedDate;

	@ManyToOne
	@JoinColumn(name = "created_user")
	private User createdUser;

	@ManyToOne
	@JoinColumn(name = "updated_user")
	private User updatedUser;

}
