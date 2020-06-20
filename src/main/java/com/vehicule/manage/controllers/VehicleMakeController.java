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


import com.vehicule.manage.models.VehicleMake;
import com.vehicule.manage.services.VehicleMakeService;

@Controller
public class VehicleMakeController {
	
	@Autowired VehicleMakeService vehicleMakeService;
	
	@GetMapping("/vehicleMakes")
	public String getvehicleMake(Model model) {
		VehicleMake b;
        
		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMake();
		model.addAttribute("vehiclemakeList", vehicleMakeList);
		return "VehicleMake";
	}

	@PostMapping("/addNewVehicleMake")
	public String addlocation(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehicleMakes";
	}
	
	@RequestMapping("/vehicleMakes/findByid")
	@ResponseBody
	public Optional<VehicleMake> findbyid(int id) {
	
		return vehicleMakeService.findById(id);
	}
	
	@RequestMapping(value = "/vehicleMakes/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updatestate(VehicleMake vehicleMake){
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehicleMakes";
	     }
	
	@RequestMapping(value = "/vehicleMakes/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deletelocation(int id){
		vehicleMakeService.delete(id);
		return "redirect:/vehicleMakes";
	     }
}
