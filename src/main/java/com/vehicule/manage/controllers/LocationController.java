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
import com.vehicule.manage.models.Location;
import com.vehicule.manage.models.State;
import com.vehicule.manage.services.CountryService;
import com.vehicule.manage.services.LocationService;
import com.vehicule.manage.services.StateService;

@Controller
public class LocationController {

	
	@Autowired StateService stateService;
	@Autowired CountryService countryService;
	@Autowired LocationService locationService;
	
	@GetMapping("/locations")
	public String getLocation(Model model) {
        Location b;
        
		List<State> stateList = stateService.getState();
		model.addAttribute("statesList", stateList);
		
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countriesList", countryList);
		
		List<Location> locationList = locationService.getLocation();
		model.addAttribute("locationsList", locationList);
		return "Location";
	}

	@PostMapping("/addNewLocation")
	public String addlocation(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}
	
	@RequestMapping("/locations/findByid")
	@ResponseBody
	public Optional<Location> findbyid(int id) {
	
		return locationService.findById(id);
	}
	
	@RequestMapping(value = "/location/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updatestate(Location location){
		locationService.save(location);
		return "redirect:/locations";
	     }
	
	@RequestMapping(value = "/locations/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deletelocation(int id){
		locationService.delete(id);
		return "redirect:/locations";
	     }
}
