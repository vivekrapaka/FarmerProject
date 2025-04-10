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

	@GetMapping("/dashboard")
	public String dashBoardPage(Model model) {
		return "index";
	}

	@GetMapping("/about")
	public String aboutPage(Model model) {
		return "about"; // renders about.html
	}

	@GetMapping("/service")
	public String servicePage(Model model) {
		return "service"; // renders service.html
	}

	@GetMapping("/product")
	public String productPage(Model model) {
		return "product"; // renders product.html
	}

}
