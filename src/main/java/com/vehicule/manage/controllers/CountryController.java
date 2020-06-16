package com.vehicule.manage.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.vehicule.manage.models.Country;
import com.vehicule.manage.services.CountryService;

@Controller
public class CountryController {

	@Autowired CountryService countryService;
	
	@GetMapping("/countries")
	public String GetCountries(Model model) {
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countriesList", countryList);
		return "country";
	}
	
	@PostMapping("/addNew")
    public String addNewCountries(Country country){
	countryService.save(country);
	return "redirect:/countries";
     }
}
