package com.example.socialMediaApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialMediaApp.business.abstracts.PostService;
import com.example.socialMediaApp.business.abstracts.UserService;
import com.example.socialMediaApp.core.utilities.results.DataResult;
import com.example.socialMediaApp.dtos.requests.postDtos.SavePostDto;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
	
	private final PostService iPostService;

	@Autowired
	
	@PostMapping("/addUser")
	public DataResult<GetUserDto> addPost(@RequestBody SavePostDto savePostDto) throws UserException {

		return this.iPostService.addPost(savePostDto); 

	}
	
}
