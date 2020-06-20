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

import com.vehicule.manage.models.VehicleStatus;
import com.vehicule.manage.services.VehicleStatutService;

@Controller
public class VehicleStatusController {
	
//	@GetMapping("/vehicleStatuses")
//	public String getVehicleStatuss()  {
//		return "VehicleStatus";
//	}	
	
@Autowired VehicleStatutService vehicleStatusService;
	
	@GetMapping("/vehicleStatuses")
	public String getvehicleStatus(Model model) {
		VehicleStatus b;
        
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();
		model.addAttribute("vehiclestatusList", vehicleStatusList);
		return "VehicleStatus";
	}

	@PostMapping("/addNewVehicleStatus")
	public String addStatus(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehicleStatuses";
	}
	
	@RequestMapping("/vehicleStatus/findByid")
	@ResponseBody
	public Optional<VehicleStatus> findbyid(int id) {
	
		return vehicleStatusService.findById(id);
	}
	
	@RequestMapping(value = "/vehicleStatus/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updatestatus(VehicleStatus vehicleMake){
		vehicleStatusService.save(vehicleMake);
		return "redirect:/vehicleStatuses";
	     }
	
	@RequestMapping(value = "/vehicleStatus/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deletestatus(int id){
		vehicleStatusService.delete(id);
		return "redirect:/vehicleStatuses";
	     }
}
