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

import com.vehicule.manage.models.VehicleType;
import com.vehicule.manage.services.VehicleTypeService;

@Controller
public class VehicleTypeController {
	

	
    @Autowired VehicleTypeService vehicleTypeService;
	
	@GetMapping("/vehicleTypes")
	public String getvehicleType(Model model) {
        
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleType();
		model.addAttribute("vehicletypeList", vehicleTypeList);
		return "VehicleType";
	}

	@PostMapping("/addNewVehicleType")
	public String addlocation(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	}
	
	@RequestMapping("/vehicleTypes/findByid")
	@ResponseBody
	public Optional<VehicleType> findbyid(int id) {
	
		return vehicleTypeService.findById(id);
	}
	
	@RequestMapping(value = "/vehicleTypes/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updatestate(VehicleType vehicleType){
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicleTypes";
	     }
	
	@RequestMapping(value = "/vehicleTypes/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deletelocation(int id){
		vehicleTypeService.delete(id);
		return "redirect:/vehicleTypes";
	     }
}
