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

import com.vehicule.manage.models.Vehicle;
import com.vehicule.manage.services.*;

@Controller
public class VehicleController {

//	@GetMapping("/vehicles")
//	public String getVehicles() {	
//		return "Vehicle";
//	}
	
	
	@Autowired VehicleService vehicleService;
	@Autowired LocationService locationService;
	@Autowired VehicleMakeService vehicleMakeService;
	@Autowired VehicleStatutService vehicleStatusService;
	@Autowired VehicleTypeService vehicleTypeService;
	@Autowired VehicleModelService vehicleModelService;
	@Autowired EmployeeService employeeService;
	
	
	@GetMapping("/vehicles")
	public String getvehicles(Model model) {
        Vehicle b;
        model.addAttribute("vehiclesList", vehicleService.getVehicle());
		model.addAttribute("locationsList", locationService.getLocation());
		model.addAttribute("vehiclemakeList", vehicleMakeService.getVehicleMake());
		model.addAttribute("vehiclestatusList", vehicleStatusService.getVehicleStatus());
		model.addAttribute("vehicletypeList", vehicleTypeService.getVehicleType());
		model.addAttribute("vehicleModelList", vehicleModelService.getVehicleModel());
		model.addAttribute("employeesList", employeeService.getEmployee());
		
		return "Vehicle";
	}

	@PostMapping("/addNewVehicle")
	public String addvehicle(Vehicle vehicle) {
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	}
	
	@RequestMapping("/vehicles/findByid")
	@ResponseBody
	
	public Optional<Vehicle> findbyid(int id) {
		
		
		return vehicleService.findById(id);
	}
	
	@RequestMapping(value = "/vehicles/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updatevehicle(Vehicle vehicle){
		vehicleService.save(vehicle);
		return "redirect:/vehicles";
	     }
	
	@RequestMapping(value = "/vehicles/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deletevehicle(int id){
		vehicleService.delete(id);
		return "redirect:/vehicles";
	     }
}
