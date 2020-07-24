package com.vehicule.manage.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vehicule.manage.services.EmployeeService;

@Controller
public class ProfileeController {
	
	@Autowired private EmployeeService employeeService;  

	@RequestMapping(value="/profile")
	public String profile(Model model, Principal principal) {
		String un = principal.getName();
		
		model.addAttribute("employee", employeeService.findByUsername(un));
		
		return "profile";
	}
}
