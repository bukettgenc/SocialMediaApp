package com.example.socialMediaApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.socialMediaApp.entities.concretes.PostImage;

public interface PostImageDao extends JpaRepository<PostImage, Integer> {

}
