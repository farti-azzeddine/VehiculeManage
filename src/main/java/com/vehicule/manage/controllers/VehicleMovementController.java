package com.vehicule.manage.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vehicule.manage.models.VehicleMovement;
import com.vehicule.manage.services.VehicleMovementService;
import com.vehicule.manage.services.VehicleService;
import com.vehicule.manage.services.CountryService;
import com.vehicule.manage.services.LocationService;

@Controller
public class VehicleMovementController {
	
//	@GetMapping("/vehicleMovements")
//	public String getVehicleMovements() {		
//		
//		return "VehicleMovement";
//	}	
	@Autowired LocationService locationService;
	@Autowired VehicleService vehicleService;
	@Autowired CountryService countryService;
	@Autowired VehicleMovementService vehicleMovementService;
	
	@GetMapping("/vehicleMovements")
	public String getvehicleMovements(Model model) {
        VehicleMovement b;
        model.addAttribute("vehiclesList", vehicleService.getVehicle());
		model.addAttribute("locationsList", locationService.getLocation());
		model.addAttribute("countriesList", countryService.getCountries());
		model.addAttribute("vehicleMovementsList", vehicleMovementService.getVehicleMovement());
		return "VehicleMovement";
	}

	@PostMapping("/addNewVehicleMovement")
	public String addvehicleMovement(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}
	
	@RequestMapping("/vehicleMovements/findByid")
	@ResponseBody
	
	public Optional<VehicleMovement> findbyid(int id) {
		
		
		return vehicleMovementService.findById(id);
	}
	
	@RequestMapping(value = "/vehicleMovements/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updatevehicleMovement(VehicleMovement vehicleMovement){
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	     }
	
	@RequestMapping(value = "/vehicleMovements/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deletevehicleMovement(int id){
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovements";
	     }
}
