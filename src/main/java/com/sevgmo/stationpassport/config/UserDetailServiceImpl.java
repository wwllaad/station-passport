package com.sevgmo.stationpassport.config;



import com.sevgmo.stationpassport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private final UserService userService;

	@Autowired
	public UserDetailServiceImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String password = userService.getPasswordByUsername(username);
		String role = userService.getRoleByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, password,
				AuthorityUtils.createAuthorityList(role));
		return user;
	}
} 