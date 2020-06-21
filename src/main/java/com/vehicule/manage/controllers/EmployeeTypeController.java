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

import com.vehicule.manage.models.EmployeeType;
import com.vehicule.manage.services.EmployeeTypeService;
@Controller
public class EmployeeTypeController {
	
@Autowired EmployeeTypeService employeeTypeService;
	
	@GetMapping("/employeeTypes")
	public String getEmployeeTypes(Model model) {
		
        
		List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeType();
		model.addAttribute("employeetypeList", employeeTypeList);
		return "EmployeeType";
	}

	@PostMapping("/addNewEmployeeTypes")
	public String addEmployeeType(EmployeeType employeeType) {
		employeeTypeService.save(employeeType);
		return "redirect:/employeeTypes";
	}
	
	@RequestMapping("/employeeTypes/findByid")
	@ResponseBody
	public Optional<EmployeeType> findbyid(int id) {
	
		return employeeTypeService.findById(id);
	}
	
	@RequestMapping(value = "/employeeTypes/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updateEmployeeType(EmployeeType employeeType){
		employeeTypeService.save(employeeType);
		return "redirect:/employeeTypes";
	     }
	
	@RequestMapping(value = "/employeeTypes/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deleteEmployeeType(int id){
		employeeTypeService.delete(id);
		return "redirect:/employeeTypes";
	     }
}

