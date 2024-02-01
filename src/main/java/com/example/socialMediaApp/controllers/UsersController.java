package com.example.socialMediaApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.socialMediaApp.business.abstracts.UserService;
import com.example.socialMediaApp.core.utilities.exceptions.businessExceptions.UserException;
import com.example.socialMediaApp.core.utilities.results.DataResult;
import com.example.socialMediaApp.dtos.requests.userDtos.SaveUserDto;
import com.example.socialMediaApp.dtos.responses.userDtos.GetUserDto;

@RestController
@RequestMapping("/api/user")
public class UsersController {

	private final UserService iUserService;

	@Autowired
	public UsersController(UserService iUserService) {
		super();
		this.iUserService = iUserService;
	}

	@PostMapping("/addUser")
	public DataResult<GetUserDto> addUser( SaveUserDto saveUserDto) throws UserException {

		return this.iUserService.addUser(saveUserDto);

	}

}
