package com.example.socialMediaApp.core.utilities.security.concretes;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.socialMediaApp.business.abstracts.UserService;
import com.example.socialMediaApp.core.utilities.mappers.ModelMapperService;
import com.example.socialMediaApp.core.utilities.results.DataResult;
import com.example.socialMediaApp.core.utilities.util.SecurityUtils;
import com.example.socialMediaApp.dataAccess.abstracts.UserDao;
import com.example.socialMediaApp.dtos.responses.userDtos.GetUserDto;
import com.example.socialMediaApp.entities.concretes.User;

@Service
public class CustomUserDetailService implements UserDetailsService {

	private UserService iUserService;
	private ModelMapperService modelMapperService;

	@Autowired

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		DataResult<GetUserDto> userDto = iUserService.findByUsername(username);

		User user = this.modelMapperService.forRequest().map(userDto, User.class);

		Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
		return UserPrincipal.builder().user(user).id(user.getId()).username(username).password(user.getPassword())
				.authorities(authorities).build();
	}

	public CustomUserDetailService(UserService iUserService, ModelMapperService modelMapperService) {
		
		super();
		this.iUserService = iUserService;
		this.modelMapperService = modelMapperService;
		
	}

}
