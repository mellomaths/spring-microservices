package com.spring.microservices.photoapp.api.gateway.security;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class AuthorizationFilter extends BasicAuthenticationFilter {

	Environment env;
	
	public AuthorizationFilter(AuthenticationManager authenticationManager, Environment env) {
		super(authenticationManager);
		this.env = env;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		String authorizationHeader = request.getHeader(env.getRequiredProperty("authorization.token.header.name"));
		if (authorizationHeader == null || !authorizationHeader.startsWith(env.getRequiredProperty("authorization.token.heade.prefix"))) {
			chain.doFilter(request, response);
			return;
		}
	}
}
