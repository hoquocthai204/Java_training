package net.sparkminds.user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.APIResponse;
import net.sparkminds.user.dto.LoginRequestDTO;
import net.sparkminds.user.dto.SignUpRequestDTO;
import net.sparkminds.user.entity.User;
import net.sparkminds.user.reponsitory.UserRepository;
import net.sparkminds.user.util.JwtUtils;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtUtils jwtUtils;

	public APIResponse signUp(SignUpRequestDTO signUpRequestDTO) {
		APIResponse apiResponse = new APIResponse();
		
		User user = new User();
		user.setFirstName(signUpRequestDTO.getFirstName());
		user.setLastName(signUpRequestDTO.getLastName());
		user.setPhone(signUpRequestDTO.getPhone());
		user.setAddress(signUpRequestDTO.getAddress());
		user.setEmail(signUpRequestDTO.getEmail());
		user.setPassword(signUpRequestDTO.getPassword());
				
		user = userRepository.save(user);
		
		apiResponse.setData(user);
		
		return apiResponse;
	}

	public APIResponse login(LoginRequestDTO loginRequestDTO) {
		APIResponse apiResponse = new APIResponse();
		
		Optional<User> user  = userRepository.findOneByEmailAndPassword(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
		
		if(user.isEmpty()) {
			apiResponse.setData("User login failed");
			return apiResponse;
		}
		
		Map<String, Object> data = new HashMap<>();
		data.put("accessToken", jwtUtils.generateJwt(user.get()));
		
		apiResponse.setData(data);
		
		return apiResponse;
	}
	
}
