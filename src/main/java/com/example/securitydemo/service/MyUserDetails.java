package com.example.securitydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.securitydemo.entity.User;
import com.example.securitydemo.repository.userRepo;
@Service
public class MyUserDetails implements UserDetailsService {
	@Autowired
	public userRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user=repo.findByUsername(username);
	if(user==null) {
		throw new UsernameNotFoundException("User not found");
	}
	return new UserPrinciples(user);
	}

}
