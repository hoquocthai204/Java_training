package net.sparkminds.user.service;

import java.util.List;
import java.util.Map;

import net.sparkminds.user.dto.LoginRequestDTO;
import net.sparkminds.user.dto.SignUpRequestDTO;
import net.sparkminds.user.entity.User;

public interface UserService {

	List<User> getListUser();
	User signup(SignUpRequestDTO signUpRequestDTO);
	Map<String, Object> login(LoginRequestDTO loginRequestDTO);
}
