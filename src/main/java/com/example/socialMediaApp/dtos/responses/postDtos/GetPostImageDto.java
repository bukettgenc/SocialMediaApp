package com.example.socialMediaApp.dtos.responses.postDtos;

import java.sql.Blob;

import com.example.socialMediaApp.entities.concretes.Post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPostImageDto {

	private Integer id;
	
	private Blob image;
	
	private Post post;
}
