package com.vehicule.manage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ApplicationController {

	
	@GetMapping("/index")
	public String Go() {
		
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		System.out.println("jjjjjjjj");
		return "register";
	}
}
