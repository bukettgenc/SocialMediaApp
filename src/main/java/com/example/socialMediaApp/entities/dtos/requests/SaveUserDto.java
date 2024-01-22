package com.example.socialMediaApp.entities.dtos.requests;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUserDto {

	private String name;

	private String surname;

	private String username;

	private String email;

	private String password;

	private Date birthday;
	
}
