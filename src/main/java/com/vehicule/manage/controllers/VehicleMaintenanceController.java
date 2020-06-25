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

import com.vehicule.manage.models.VehicleMaintenance;
import com.vehicule.manage.services.VehicleMaintenanceService;
import com.vehicule.manage.services.SupplierService;
import com.vehicule.manage.services.VehicleService;

@Controller
public class VehicleMaintenanceController {
	
//	@GetMapping("/vehicleMaintenances")
//	public String getVehicleMaintenances() {		
//		return "VehicleMaintenance";
//	}

	@Autowired VehicleService vehicleService;
	@Autowired SupplierService supplierService;
	@Autowired VehicleMaintenanceService vehicleMaintenanceService;
	
	@GetMapping("/vehicleMaintenances")
	public String getvehicleMaintenances(Model model) {
        VehicleMaintenance b;
        
		model.addAttribute("supplierList", supplierService.getSupplier());
		model.addAttribute("vehicleList", vehicleService.getVehicle());
		model.addAttribute("vehicleMaintenancesList", vehicleMaintenanceService.getVehicleMaintenance());
		return "VehicleMaintenance";
	}

	@PostMapping("/addNewVehicleMaintenance")
	public String addvehicleMaintenance(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	}
	
	@RequestMapping("/vehicleMaintenances/findByid")
	@ResponseBody
	
	public Optional<VehicleMaintenance> findbyid(int id) {
		
		
		return vehicleMaintenanceService.findById(id);
	}
	
	@RequestMapping(value = "/vehicleMaintenances/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updatevehicleMaintenance(VehicleMaintenance vehicleMaintenance){
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehicleMaintenances";
	     }
	
	@RequestMapping(value = "/vehicleMaintenances/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deletevehicleMaintenance(int id){
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehicleMaintenances";
	     }
}
