package com.example.socialMediaApp.dtos.responses.userDtos;

import java.util.Date;

import com.example.socialMediaApp.core.utilities.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserDto {
	
	private Integer id;

	private String name;

	private String surname;

	private String username;

	private String email;

	private String password;

	private Date birthday;
	
	private Role role;
	
}
