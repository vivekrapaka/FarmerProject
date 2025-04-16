package com.farmersell.FarmerSell.security;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

	 public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
	        // Store error message in session
	        request.getSession().setAttribute("error_message", exception.getMessage());
	        // Redirect to login page with error parameter
	        super.setDefaultFailureUrl("/login?error=true");
	        super.onAuthenticationFailure(request, response, exception);
	    }
}
