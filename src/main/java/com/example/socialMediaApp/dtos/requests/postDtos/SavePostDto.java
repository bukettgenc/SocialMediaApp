package com.example.socialMediaApp.dtos.requests.postDtos;

import java.util.List;

import com.example.socialMediaApp.entities.concretes.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePostDto {

	private List<SavePostImageDto> postImages;

	private List<SavePostTextDto> postTexts;
	
	private User user;

}
