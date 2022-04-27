package net.sparkminds.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import common.APIResponse;
import net.sparkminds.user.dto.LoginRequestDTO;
import net.sparkminds.user.dto.SignUpRequestDTO;
import net.sparkminds.user.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(path = "/api/register", method = RequestMethod.POST)
	public ResponseEntity<APIResponse> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO) {
		APIResponse apiResponse = loginService.signUp(signUpRequestDTO);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@RequestMapping(path = "/api/login", method = RequestMethod.POST)
	public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDTO loginRequestDTO){
		APIResponse apiResponse = loginService.login(loginRequestDTO);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
}
