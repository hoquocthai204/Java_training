package net.sparkminds.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import common.APIResponse;
import net.sparkminds.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping("/api/users")
	public ResponseEntity<APIResponse> getUsers(){
		APIResponse apiResponse = userService.getUser();
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
}
