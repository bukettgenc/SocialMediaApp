package com.example.socialMediaApp.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.socialMediaApp.business.abstracts.UserService;
import com.example.socialMediaApp.core.utilities.enums.Role;
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
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UserManager(UserDao iUserDao, ModelMapperService modelMapperService, PasswordEncoder passwordEncoder) {
		super();
		this.iUserDao = iUserDao;
		this.modelMapperService = modelMapperService;
		this.passwordEncoder = passwordEncoder;
	}

	public DataResult<GetUserDto> addUser(SaveUserDto saveUserDto) throws UserException {
		usernameIsExists(saveUserDto.getUsername());
		emailIsExists(saveUserDto.getEmail());

		saveUserDto.setPassword(passwordEncoder.encode(saveUserDto.getPassword()));
		saveUserDto.setRole(Role.USER);

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

	public void usernameIsEmptyOrNull(String username) throws UserException {

		if (username == null || username.equals("")) {
			throw new UserException(Messages.UserMessages.KULLANICI_ADI_BOS);
		}

	}

	public DataResult<GetUserDto> findByUsername(String username) {
				
		User user = this.iUserDao.findByUsername(username).orElseThrow(null);
		GetUserDto getUserDto = this.modelMapperService.forResponse().map(user, GetUserDto.class);

		return new SuccessDataResult<GetUserDto>(getUserDto, Messages.UserMessages.KULLANICI_BULMA_BASARILI);

	}

}
