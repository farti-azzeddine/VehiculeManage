package com.vehicule.manage.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vehicule.manage.models.Country;
import com.vehicule.manage.services.CountryService;

@Controller
public class CountryController {

	@Autowired CountryService countryService;
	
	@GetMapping("/countries")
	public String GetCountries(Model model) {
		
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countriesList", countryList);
		return "countrypage";
	}

	@PostMapping("/addNew")
    public String addNewCountries(Country country){
	countryService.save(country);
	return "redirect:/countries";
     }
	
	@RequestMapping("/countries/finByid")
	@ResponseBody
	public Optional<Country> findbyid(int id) {
		return countryService.findById(id);
	}
	
	@RequestMapping(value = "/countries/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updatecountry(Country country){
		countryService.save(country);
		return "redirect:/countries";
	     }
	
	@RequestMapping(value = "/countries/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deletecountry(int id){
		countryService.delete(id);
		return "redirect:/countries";
	     }
}
