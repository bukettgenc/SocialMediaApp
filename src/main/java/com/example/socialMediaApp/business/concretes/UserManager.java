package com.example.socialMediaApp.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.socialMediaApp.business.abstracts.UserService;
import com.example.socialMediaApp.core.utilities.exceptions.businessExceptions.UserException;
import com.example.socialMediaApp.core.utilities.mappers.ModelMapperService;
import com.example.socialMediaApp.core.utilities.messages.Messages;
import com.example.socialMediaApp.core.utilities.results.DataResult;
import com.example.socialMediaApp.core.utilities.results.SuccessDataResult;
import com.example.socialMediaApp.dataAccess.abstracts.UserDao;
import com.example.socialMediaApp.dtos.requests.userDtos.SaveUserDto;
import com.example.socialMediaApp.dtos.responses.userDtos.GetUserDto;
import com.example.socialMediaApp.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao iUserDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public UserManager(UserDao iUserDao, ModelMapperService modelMapperService) {
		super();
		this.iUserDao = iUserDao;
		this.modelMapperService = modelMapperService;
	}

	public DataResult<GetUserDto> addUser(SaveUserDto saveUserDto) throws UserException {

		usernameIsExists(saveUserDto.getUsername());
		emailIsExists(saveUserDto.getEmail());

		User user = this.modelMapperService.forRequest().map(saveUserDto, User.class);
		user = this.iUserDao.save(user);
		GetUserDto getUserDto = this.modelMapperService.forResponse().map(user, GetUserDto.class);

		return new SuccessDataResult<GetUserDto>(getUserDto, Messages.UserMessages.KULLANICI_EKLEME_BASARILI);

	}

	public void usernameIsExists(String username) throws UserException {

		if (this.iUserDao.existsByUsername(username)) {
			throw new UserException(Messages.UserMessages.KULLANICI_ADI_MEVCUT);
		}

	}

	public void emailIsExists(String email) throws UserException {

		if (this.iUserDao.existsByEmail(email)) {
			throw new UserException(Messages.UserMessages.EMAIL_MEVCUT);
		}

	}

}
