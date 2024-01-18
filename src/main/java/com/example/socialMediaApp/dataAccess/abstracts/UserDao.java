package com.example.socialMediaApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialMediaApp.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
