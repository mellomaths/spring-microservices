package com.spring.microservices.photoapp.api.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
	
	private final Environment env;
	
	@Autowired
	public Security(Environment env) {
		this.env = env;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, env.getRequiredProperty("api.registration.url.path")).permitAll()
			.antMatchers(HttpMethod.POST, env.getRequiredProperty("api.login.url.path")).permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilter(new AuthorizationFilter(authenticationManager(), env));
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// Make the API stateless
		// Spring Security will never create an HttpSession and it will never use itto obtain the SecurityContext
	}

}
