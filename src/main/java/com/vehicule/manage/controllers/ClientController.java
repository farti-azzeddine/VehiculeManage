package com.vehicule.manage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

	@GetMapping("/clients")
	public String Getclients() {
		return "Client";
	}
}
