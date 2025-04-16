package com.farmersell.FarmerSell.securityconfig;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.farmersell.FarmerSell.entity.User;
import com.farmersell.FarmerSell.repository.UserRepository;

@Component
public class CustomeAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	@Lazy
	PasswordEncoder passwordEncoder;

	    @Override
	    public Authentication authenticate(Authentication authentication) {
	        String username = authentication.getName();
	        String password = authentication.getCredentials().toString();

	        // Load user from DB
	        User userDetails = userRepository.findByUserName(username);

	        // Match password
	        if (passwordEncoder.matches(password, userDetails.getPassword())) {
	            return new UsernamePasswordAuthenticationToken(
	                username,
	                password,
	                Collections.emptyList()
	            );
	        } else {
	            throw new BadCredentialsException("Invalid username or password");
	        }
	    }

	    @Override
	    public boolean supports(Class<?> authentication) {
	        return authentication.equals(UsernamePasswordAuthenticationToken.class);
	    }

	
}
