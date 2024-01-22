package com.example.socialMediaApp.dtos.responses;

import java.util.Date;
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
	
}
