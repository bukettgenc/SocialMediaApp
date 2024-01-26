package com.example.socialMediaApp.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.socialMediaApp.business.abstracts.PostService;
import com.example.socialMediaApp.core.utilities.exceptions.businessExceptions.PostException;
import com.example.socialMediaApp.core.utilities.mappers.ModelMapperService;
import com.example.socialMediaApp.core.utilities.messages.Messages;
import com.example.socialMediaApp.core.utilities.results.DataResult;
import com.example.socialMediaApp.core.utilities.results.SuccessDataResult;
import com.example.socialMediaApp.dataAccess.abstracts.PostDao;
import com.example.socialMediaApp.dtos.requests.postDtos.SavePostDto;
import com.example.socialMediaApp.dtos.responses.postDtos.GetPostDto;
import com.example.socialMediaApp.entities.concretes.Post;

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

	public DataResult<GetPostDto> addPost(SavePostDto savePostDto) throws PostException {
		  
//		List<PostImage> postImageList = savePostDto.getPostImages().stream().map(postImage -> this.modelMapperService.forRequest().map(postImage, PostImage.class))
//	                .collect(Collectors.toList());
//		List<PostText> postTextList = savePostDto.getPostTexts().stream().map(postText -> this.modelMapperService.forRequest().map(postText, PostText.class))
//                .collect(Collectors.toList());
//	
//		Post post =new Post();
//		post.setPostImages(postImageList);
//		post.setPostTexts(postTextList);
//		post.setUser(null);
		Post post = this.modelMapperService.forRequest().map(savePostDto, Post.class);
		post = this.iPostDao.save(post);
		GetPostDto getPostDto = this.modelMapperService.forResponse().map(post, GetPostDto.class);

		return new SuccessDataResult<GetPostDto>(getPostDto, Messages.PostMessages.POST_EKLEME_BASARILI);

	}
}
