package com.vehicule.manage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationController {

	@GetMapping("/locations")
	public String getStates() {	
		return "Location";
	}
}
