package com.example.socialMediaApp.business.concretes;

import org.springframework.stereotype.Service;
import com.example.socialMediaApp.business.abstracts.UserService;
import com.example.socialMediaApp.core.utilities.exceptions.businessExceptions.UserException;
import com.example.socialMediaApp.core.utilities.mappers.ModelMapperService;
import com.example.socialMediaApp.core.utilities.results.DataResult;
import com.example.socialMediaApp.core.utilities.results.SuccessDataResult;
import com.example.socialMediaApp.dataAccess.abstracts.UserDao;
import com.example.socialMediaApp.dtos.requests.SaveUserDto;
import com.example.socialMediaApp.entities.concretes.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

	private UserDao iUserDao;
	private ModelMapperService modelMapperService;

	public DataResult<User> addUser(SaveUserDto saveUserDto) throws UserException {

		User user = this.modelMapperService.forRequest().map(saveUserDto, User.class);
		usernameIsExists(user.getUsername());
		emailIsExists(user.getEmail());
		
		return new SuccessDataResult<User>(this.iUserDao.save(user));

	}

	public void usernameIsExists(String username) throws UserException {
		
		if (this.iUserDao.existsByUsername(username)) {
			throw new UserException("Kullanici adi zaten mevcut");
		}
		
	}

	public void emailIsExists(String email) throws UserException {
		
		if (this.iUserDao.existsByEmail(email)) {
			throw new UserException("Email zaten mevcut");
		}
		
	}
	
}
