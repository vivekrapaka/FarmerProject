package com.farmersell.FarmerSell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.farmersell.FarmerSell.entity.User;
import com.farmersell.FarmerSell.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	
	public boolean validateLogin(String username , String password) {
		User userdata = userRepository.findByUserName(username);
		
		if(userdata != null && passwordEncoder.matches(password, userdata.getPassword())) {
			return true;
		}
		return false;
	}

}
