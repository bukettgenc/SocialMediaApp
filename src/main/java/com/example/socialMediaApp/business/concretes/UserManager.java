package com.example.socialMediaApp.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.socialMediaApp.business.abstracts.UserService;
import com.example.socialMediaApp.common.utilities.mappers.ModelMapperService;
import com.example.socialMediaApp.dataAccess.abstracts.UserDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
	
	private UserDao iUserDao;
	private ModelMapperService modelMapperService;
	
}
