package com.farmersell.FarmerSell.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.farmersell.FarmerSell.entity.User;
import com.farmersell.FarmerSell.repository.UserRepository;
import com.farmersell.FarmerSell.vo.UserVo;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody UserVo uservo){
		System.out.println("calling the register api");
		try {
		
		User userdata = userRepository.findByUserName(uservo.getUserName());
		
		if(userdata != null) {
			ResponseEntity.ok("User Already Register");
		}
		
		
		User data = new User();
		data.setName(uservo.getName());
		data.setLastName(uservo.getLastName());
		data.setPassword(passwordEncoder.encode(uservo.getPassword()));
		data.setUserName(uservo.getUserName());
		data.setEmail(uservo.getEmail());
		userRepository.save(data);
		
		return ResponseEntity.ok("register successfully");
	}
		catch (Exception e) {
			return ResponseEntity.ok("registion failed");
		}
	}
}
