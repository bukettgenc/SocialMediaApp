package com.example.socialMediaApp.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.socialMediaApp.business.abstracts.UserService;
import com.example.socialMediaApp.dataAccess.abstracts.UserDao;

@Service
public class UserManager implements UserService{
	@Autowired
	private UserDao iUserDao;
}
