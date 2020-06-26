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

import com.vehicule.manage.models.VehicleHire;
import com.vehicule.manage.services.*;

@Controller
public class VehicleHireController {
	
//	@GetMapping("/vehicleHires")
//	public String getVehicleHires() {		
//		
//		return "VehicleHire";
//	}
	
	@Autowired ClientService clientService;
	@Autowired LocationService locationService;
	@Autowired VehicleService vehicleService;
	@Autowired VehicleHireService vehicleHireService;
	
	@GetMapping("/vehicleHires")
	public String getvehicleHires(Model model) {
        VehicleHire b;
		model.addAttribute("clientsList", clientService.getClient());
		model.addAttribute("vehicleList", vehicleService.getVehicle());
		model.addAttribute("locationsList", locationService.getLocation());
		model.addAttribute("vehicleHiresList", vehicleHireService.getVehicleHire());
		return "VehicleHire";
	}

	@PostMapping("/addNewVehicleHire")
	public String addvehicleHire(VehicleHire vehicleHire) {
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHires";
	}
	
	@RequestMapping("/vehicleHires/findByid")
	@ResponseBody
	
	public Optional<VehicleHire> findbyid(int id) {
		
		
		return vehicleHireService.findById(id);
	}
	
	@RequestMapping(value = "/vehicleHires/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updatevehicleHire(VehicleHire vehicleHire){
		vehicleHireService.save(vehicleHire);
		return "redirect:/vehicleHires";
	     }
	
	@RequestMapping(value = "/vehicleHires/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deletevehicleHire(int id){
		vehicleHireService.delete(id);
		return "redirect:/vehicleHires";
	     }

}
