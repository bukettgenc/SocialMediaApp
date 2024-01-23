package com.example.socialMediaApp.dtos.requests.userDtos;

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
	
	private String rePassword;

	private Date birthday;
	
}
