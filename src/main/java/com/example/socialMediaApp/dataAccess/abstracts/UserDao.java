package com.example.socialMediaApp.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialMediaApp.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	boolean existsByUsername(String username);

	boolean existsByEmail(String email);
	
	User save(User user);
	
	Optional<User> findByUsername(String username);

}
