package com.example.socialMediaApp.dtos.requests.postDtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePostDto {

	private List<SavePostImageDto> postImages;

	private List<SavePostTextDto> postTexts;
	
	private Integer userId;

}
