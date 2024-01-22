package com.example.socialMediaApp.business.abstracts;

import com.example.socialMediaApp.core.utilities.exceptions.businessExceptions.UserException;
import com.example.socialMediaApp.core.utilities.results.DataResult;
import com.example.socialMediaApp.dtos.requests.SaveUserDto;
import com.example.socialMediaApp.entities.concretes.User;

public interface UserService {
	
	DataResult<User> addUser(SaveUserDto saveUserDto) throws UserException;

}
