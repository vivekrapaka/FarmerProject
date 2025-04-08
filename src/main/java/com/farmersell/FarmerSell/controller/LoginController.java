package com.farmersell.FarmerSell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.farmersell.FarmerSell.entity.User;
import com.farmersell.FarmerSell.repository.UserRepository;
import com.farmersell.FarmerSell.service.UserService;
import com.farmersell.FarmerSell.vo.LoginVo;
import com.farmersell.FarmerSell.vo.UserVo;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody UserVo uservo){
		System.out.println("calling the register api");
		try {
		
		User userdata = userRepository.findByUserName(uservo.getUserName());
		
		if(userdata != null) {
			ResponseEntity.ok("User Already Register");
		}
		
		
		User data = new User();
		data.setName(uservo.getFirstName());
		data.setLastName(uservo.getLastName());
		data.setPassword(passwordEncoder.encode(uservo.getPassword()));
		data.setUserName(uservo.getUserName());
		data.setEmail(uservo.getEmail());
		userRepository.save(data);
		
		return ResponseEntity.ok("register successfully");
	}
		catch (Exception e) {
			System.out.println("printing the exception"+ e);
			return ResponseEntity.ok("registion failed");
		}
	}
	@PostMapping("/login")
	public ResponseEntity<String> loginValidate(@RequestBody LoginVo loginVo){
		System.out.println("calling the /login api");
		try {
		boolean isvalid = userService.validateLogin(loginVo.getUserName(), loginVo.getPassword());
		if(isvalid) {
			return ResponseEntity.ok("login successfully");
			
		}else {
			return ResponseEntity.ok("invalid crediationals");
		}
		}
		catch(Exception e) {
			return ResponseEntity.ok("Something went wrong");
		}
	}
}
