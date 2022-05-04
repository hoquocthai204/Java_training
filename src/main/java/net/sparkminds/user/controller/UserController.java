package net.sparkminds.user.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sparkminds.user.dto.LoginRequestDTO;
import net.sparkminds.user.dto.SignUpRequestDTO;
import net.sparkminds.user.entity.User;
import net.sparkminds.user.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		return ResponseEntity.ok(userService.getListUser());
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@Valid @RequestBody SignUpRequestDTO signUpRequestDTO){
		return ResponseEntity.ok(userService.signup(signUpRequestDTO));
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO){
		return ResponseEntity.ok(userService.login(loginRequestDTO));
	}
}
