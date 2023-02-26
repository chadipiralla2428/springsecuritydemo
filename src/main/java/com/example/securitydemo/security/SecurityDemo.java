package com.example.securitydemo.security;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
@EnableWebSecurity
public class SecurityDemo extends WebSecurityConfigurerAdapter{
	@Autowired
	public UserDetailsService userDetailsService;
	@Bean
	public AuthenticationProvider authProvider(){
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		 return  provider;
		
		
	}
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		List<UserDetails> list=new ArrayList<>();
//		list.add(User.withDefaultPasswordEncoder().username("siva").password("2428").roles("admin").build());
//		return new InMemoryUserDetailsManager(list);
//		
//	}
	

}
