package com.example.socialMediaApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialMediaApp.business.abstracts.PostService;
import com.example.socialMediaApp.business.abstracts.UserService;
import com.example.socialMediaApp.core.utilities.results.DataResult;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
	
	private final PostService iPostService;

	@Autowired
	
	@PostMapping("/addUser")
	public DataResult<GetUserDto> addPost(@RequestBody SaveUserDto saveUserDto) throws UserException {

		return this.iUserService.addPost(saveUserDto);

	}
	
}
