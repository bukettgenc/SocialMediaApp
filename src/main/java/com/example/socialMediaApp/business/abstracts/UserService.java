package com.example.socialMediaApp.business.abstracts;

import com.example.socialMediaApp.core.utilities.exceptions.businessExceptions.UserException;
import com.example.socialMediaApp.core.utilities.results.DataResult;
import com.example.socialMediaApp.dtos.requests.userDtos.SaveUserDto;
import com.example.socialMediaApp.dtos.responses.userDtos.GetUserDto;

public interface UserService {
	
	DataResult<GetUserDto> addUser(SaveUserDto saveUserDto) throws UserException;

}
