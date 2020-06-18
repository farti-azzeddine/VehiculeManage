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
import com.vehicule.manage.models.State;
import com.vehicule.manage.repositories.StateRepository;
import com.vehicule.manage.services.CountryService;
import com.vehicule.manage.services.StateService;

@Controller
public class StateController {
	
	@Autowired StateService stateService;
	@Autowired CountryService countryService;
	
	@GetMapping("/states")
	public String getStates(Model model) {
        State b;
		List<State> stateList = stateService.getState();
		model.addAttribute("statesList", stateList);
		
		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countriesList", countryList);
		
		return "State";
	}

	@PostMapping("/addNewState")
	public String addstate(State state) {
		stateService.save(state);
		return "redirect:/states";
	}
	
	@RequestMapping("/states/findByid")
	@ResponseBody
	
	public Optional<State> findbyid(int id) {
		
		
		return stateService.findById(id);
	}
	
	@RequestMapping(value = "/states/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updatestate(State state){
		stateService.save(state);
		return "redirect:/states";
	     }
	
	@RequestMapping(value = "/states/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deletestate(int id){
		stateService.delete(id);
		return "redirect:/states";
	     }
}
