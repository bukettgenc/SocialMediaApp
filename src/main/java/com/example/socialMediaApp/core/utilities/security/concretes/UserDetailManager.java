package com.example.socialMediaApp.core.utilities.security.concretes;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.socialMediaApp.core.utilities.exceptions.businessExceptions.UsernameNotFoundException;
import com.example.socialMediaApp.core.utilities.security.abstracts.UserDetailService;
import com.example.socialMediaApp.core.utilities.util.SecurityUtils;
import com.example.socialMediaApp.dataAccess.abstracts.UserDao;
import com.example.socialMediaApp.entities.concretes.User;

@Service
public class UserDetailManager implements UserDetailService {

	@Autowired
	private UserDao iUserDao;

	public UserDetailManager(UserDao iUserDao) {
		super();
		this.iUserDao = iUserDao;
	}

	public UserDetails loadByUsername(String username) throws UsernameNotFoundException {

		User user = iUserDao.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

		Set<GrantedAuthority> authorities=Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
		return UserPrincipal.builder()
				.user(user)
				.id(user.getId())
				.username(username)
				.password(user.getPassword())
				.authorities(authorities).build();
	}
}
