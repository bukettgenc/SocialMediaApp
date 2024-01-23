package com.example.socialMediaApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.socialMediaApp.entities.concretes.Post;

public interface PostDao extends JpaRepository<Post, Integer> {

}
