package com.appsdeveloperblog.app.ws.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.shared.Utils;
import com.appsdeveloperblog.app.ws.ui.model.request.UserRequest;
import com.appsdeveloperblog.app.ws.ui.model.response.UserResponse;

@Service
public class UserService {
	
	Map<String, UserResponse> userRepository;
	Utils utils;
	
	public UserService() {}
	
	@Autowired
	public UserService(Utils utils) {
		this.utils = utils;
	}
	
	public UserResponse create(UserRequest userData) {
		String userId = utils.generateUserId();
		UserResponse user = new UserResponse(userId, "Matheus", "Mello de Lima", "mellomatheuslima@gmail.com");
		if (userRepository == null) {
			userRepository = new HashMap<>();  
		}
		 
		userRepository.put(userId, user);
		return user;
	}

}
