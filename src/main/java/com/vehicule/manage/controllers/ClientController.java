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

import com.vehicule.manage.models.*;
import com.vehicule.manage.services.*;

@Controller
public class ClientController {

	@Autowired StateService stateService;
	@Autowired CountryService countryService;
	@Autowired ClientService clientService;
	
	@GetMapping("/clients")
	public String getclients(Model model) {
        Client b;
        
		model.addAttribute("statetsList", stateService.getState());
		model.addAttribute("countriesList", countryService.getCountries());
		model.addAttribute("clientsList", clientService.getClient());
		return "Client";
	}

	@PostMapping("/addNewClient")
	public String addclient(Client client) {
		clientService.save(client);
		return "redirect:/clients";
	}
	
	@RequestMapping("/clients/findByid")
	@ResponseBody
	
	public Optional<Client> findbyid(int id) {
		
		
		return clientService.findById(id);
	}
	
	@RequestMapping(value = "/clients/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updateclient(Client client){
		clientService.save(client);
		return "redirect:/clients";
	     }
	
	@RequestMapping(value = "/clients/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deleteclient(int id){
		clientService.delete(id);
		return "redirect:/clients";
	     }
}

