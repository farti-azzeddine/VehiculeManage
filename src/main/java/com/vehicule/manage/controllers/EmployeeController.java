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

import com.vehicule.manage.models.Employee;
import com.vehicule.manage.services.*;

@Controller
public class EmployeeController {

//	@GetMapping("/employees")
//	public String getEmployees() {
//		return "Employee";
//	}
	
	@Autowired EmployeeTypeService employeeTypeService;
	@Autowired JobTtitleService jobTtitleService ;
	@Autowired StateService stateService;
	@Autowired CountryService countryService;
	@Autowired EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String getemployees(Model model) {
        
        model.addAttribute("employeetypeList", employeeTypeService.getEmployeeType());
		model.addAttribute("jobtitleList", jobTtitleService.getJobTitle());
		model.addAttribute("statesList", stateService.getState());
		model.addAttribute("countriesList", countryService.getCountries());
		model.addAttribute("employeesList", employeeService.getEmployee());
		return "Employee";
	}

	@PostMapping("/addNewEmployee")
	public String addemployee(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping("/employees/findByid")
	@ResponseBody
	
	public Optional<Employee> findbyid(int id) {
		
		
		return employeeService.findById(id);
	}
	
	@RequestMapping(value = "/employees/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updateemployee(Employee employee){
		employeeService.save(employee);
		return "redirect:/employees";
	     }
	
	@RequestMapping(value = "/employees/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deleteemployee(int id){
		employeeService.delete(id);
		return "redirect:/employees";
	     }
}
