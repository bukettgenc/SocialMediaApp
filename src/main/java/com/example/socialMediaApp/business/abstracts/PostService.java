package com.example.socialMediaApp.business.abstracts;

import com.example.socialMediaApp.core.utilities.exceptions.businessExceptions.PostException;
import com.example.socialMediaApp.core.utilities.results.DataResult;
import com.example.socialMediaApp.dtos.requests.postDtos.SavePostDto;
import com.example.socialMediaApp.dtos.responses.postDtos.GetPostDto;

public interface PostService {
	DataResult<GetPostDto> addPost(SavePostDto savePostDto) throws PostException;
}
