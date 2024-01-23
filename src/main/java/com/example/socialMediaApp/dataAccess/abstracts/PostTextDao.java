package com.example.socialMediaApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.socialMediaApp.entities.concretes.PostText;

public interface PostTextDao extends JpaRepository<PostText, Integer> {

}

