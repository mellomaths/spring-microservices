package com.spring.microservices.photoapp.api.users.application.http.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.microservices.photoapp.api.users.domain.users.UsersAuthenticationService;
import com.spring.microservices.photoapp.api.users.domain.users.UsersService;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private UsersService userService;
	
	@Autowired
	private UsersAuthenticationService usersAuthenticationService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/**")
			.hasIpAddress(environment.getProperty("apigateway.ip.address"))
			.and().addFilter(getAuthenticationFilter());
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usersAuthenticationService).passwordEncoder(passwordEncoder);
	}
	
	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(userService, usersAuthenticationService, authenticationManager());
		authenticationFilter.setFilterProcessesUrl(environment.getProperty("login.url.path"));
		return authenticationFilter;
	}
 
}
