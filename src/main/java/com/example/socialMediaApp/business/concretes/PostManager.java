package com.example.socialMediaApp.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.socialMediaApp.business.abstracts.PostService;
import com.example.socialMediaApp.core.utilities.exceptions.businessExceptions.PostException;
import com.example.socialMediaApp.core.utilities.mappers.ModelMapperService;
import com.example.socialMediaApp.core.utilities.results.DataResult;
import com.example.socialMediaApp.dataAccess.abstracts.PostDao;
import com.example.socialMediaApp.dtos.requests.postDtos.SavePostDto;
import com.example.socialMediaApp.dtos.responses.postDtos.GetPostDto;

@Service
public class PostManager implements PostService {

	private PostDao iPostDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public PostManager(PostDao iPostDao, ModelMapperService modelMapperService) {
		super();
		this.iPostDao = iPostDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<GetPostDto> addPost(SavePostDto savePostDto) throws PostException {
		// TODO Auto-generated method stub
		return null;
	}

}
