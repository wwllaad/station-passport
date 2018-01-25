package com.sevgmo.stationpassport.config;


import com.sevgmo.stationpassport.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private final UserMapper userMapper;

	@Autowired
	public UserDetailServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String password = userMapper.getPasswordByUsername(username);
		String role = userMapper.getRoleByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, password,
				AuthorityUtils.createAuthorityList(role));
		return user;
	}
} 