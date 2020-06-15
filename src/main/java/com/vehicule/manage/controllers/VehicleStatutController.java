package com.vehicule.manage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VehicleStatutController {
	
	@GetMapping("/vehicleStatuses")
	public String getVehicleStatuss()  {
		return "VehicleStatus";
	}	

}
