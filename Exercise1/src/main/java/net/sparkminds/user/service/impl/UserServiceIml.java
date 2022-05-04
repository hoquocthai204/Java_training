package net.sparkminds.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.sparkminds.user.dto.LoginRequestDTO;
import net.sparkminds.user.dto.SignUpRequestDTO;
import net.sparkminds.user.entity.User;
import net.sparkminds.user.reponsitory.UserRepository;
import net.sparkminds.user.service.UserService;
import net.sparkminds.user.util.JwtUtils;

@Service
@Transactional(readOnly = true)
public class UserServiceIml implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public List<User> getListUser() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public User signup(SignUpRequestDTO signUpRequestDTO) {

		User user = new User();
		user.setFirstName(signUpRequestDTO.getFirstName());
		user.setLastName(signUpRequestDTO.getLastName());
		user.setPhone(signUpRequestDTO.getPhone());
		user.setAddress(signUpRequestDTO.getAddress());
		user.setEmail(signUpRequestDTO.getEmail());
		user.setPassword(signUpRequestDTO.getPassword());

		return userRepository.save(user);
	}

	@Override
	@Transactional
	public Map<String,Object> login(LoginRequestDTO loginRequestDTO) {
		User user = userRepository.findOneByEmailAndPassword(loginRequestDTO.getEmail(), loginRequestDTO.getPassword())
				.orElseThrow(() -> new EntityNotFoundException("email and password are not exist"));

		Map<String, Object> data = new HashMap<>();
		data.put("accessToken", jwtUtils.generateJwt(user));
		
		return data;

	}

}
