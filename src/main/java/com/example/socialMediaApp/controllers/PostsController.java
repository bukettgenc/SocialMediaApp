package com.example.socialMediaApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.socialMediaApp.business.abstracts.PostService;
import com.example.socialMediaApp.core.utilities.exceptions.businessExceptions.PostException;
import com.example.socialMediaApp.core.utilities.results.DataResult;
import com.example.socialMediaApp.dtos.requests.postDtos.SavePostDto;
import com.example.socialMediaApp.dtos.responses.postDtos.GetPostDto;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
	
	private final PostService iPostService;

	@Autowired
	public PostsController(PostService iPostService) {
		super();
		this.iPostService = iPostService;
	}
	
	
	@PostMapping("/addPost")
	public DataResult<GetPostDto> addPost(@RequestBody SavePostDto savePostDto) throws PostException {

		return this.iPostService.addPost(savePostDto); 

	}

	
}
