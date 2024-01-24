package com.example.socialMediaApp.dtos.responses.postDtos;

import java.util.List;

import com.example.socialMediaApp.entities.concretes.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPostDto {
	
	private Integer id;	
	
	private User user;

	private List<GetPostImageDto> postImages;

	private List<GetPostTextDto> postTexts;

}
