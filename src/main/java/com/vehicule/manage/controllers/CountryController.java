package com.vehicule.manage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CountryController {
	
	@GetMapping("/countries")
	public String GetCountries() {
		return "Country";
	}

}
