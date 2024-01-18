package com.example.socialMediaApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialMediaApp.business.abstracts.UserService;

@RestController
public class UsersController {
	@Autowired
	private UserService iUserService;
}
