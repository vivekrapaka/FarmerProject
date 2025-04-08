package com.farmersell.FarmerSell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
	
	@GetMapping("/loginPage")
	public String loginPage(Model model) {
		System.out.println("loginPage");
		return "login";
	}
	
	@GetMapping("/registrationPage")
	public String registrationPage(Model model) {
		return "registration";
	}
	
}
