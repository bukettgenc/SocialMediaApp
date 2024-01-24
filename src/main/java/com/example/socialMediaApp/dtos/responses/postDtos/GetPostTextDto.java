package com.example.socialMediaApp.dtos.responses.postDtos;

import com.example.socialMediaApp.entities.concretes.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPostTextDto {

	private Integer id;

	private String content;

	private Post post;
}
