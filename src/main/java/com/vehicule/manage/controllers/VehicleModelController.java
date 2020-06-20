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

import com.vehicule.manage.models.VehicleModel;
import com.vehicule.manage.services.VehicleModelService;

@Controller
public class VehicleModelController {
	
@Autowired VehicleModelService vehicleModelService;
	
	@GetMapping("/vehicleModels")
	public String getvehicleModel(Model model) {
		VehicleModel b;
        
		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModel();
		model.addAttribute("vehicleModelList", vehicleModelList);
		return "VehicleModel";
	}

	@PostMapping("/addNewVehicleModel")
	public String addlocation(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModels";
	}
	
	@RequestMapping("/vehicleModels/findByid")
	@ResponseBody
	public Optional<VehicleModel> findbyid(int id) {
	
		return vehicleModelService.findById(id);
	}
	
	@RequestMapping(value = "/vehicleModels/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updatestate(VehicleModel vehicleModel){
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehicleModels";
	     }
	
	@RequestMapping(value = "/vehicleModels/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deletelocation(int id){
		vehicleModelService.delete(id);
		return "redirect:/vehicleModels";
	     }
}
