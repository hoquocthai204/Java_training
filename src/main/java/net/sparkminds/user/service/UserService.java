package net.sparkminds.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.APIResponse;
import net.sparkminds.user.reponsitory.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public APIResponse getUser() {
		APIResponse apiResponse = new APIResponse();
		apiResponse.setData(userRepository.findAll());
		return apiResponse;
	}
	
}
