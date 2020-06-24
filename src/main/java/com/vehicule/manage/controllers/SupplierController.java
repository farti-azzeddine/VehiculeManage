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

import com.vehicule.manage.models.*;
import com.vehicule.manage.services.*;
@Controller
public class SupplierController {
	
		
	@Autowired StateService stateService;
	@Autowired CountryService countryService;
	@Autowired SupplierService supplierService;

	@GetMapping("/suppliers")
	public String getsuppliers(Model model) {
        Supplier b;
       
		model.addAttribute("statetsList", stateService.getState());
		model.addAttribute("countriesList", countryService.getCountries());
		model.addAttribute("suppliersList", supplierService.getSupplier());
		return "Supplier";
	}

	@PostMapping("/addNewSupplier")
	public String addsupplier(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers";
	}
	
	@RequestMapping("/suppliers/findByid")
	@ResponseBody
	
	public Optional<Supplier> findbyid(int id) {
				
		return supplierService.findById(id);
	}
	
	@RequestMapping(value = "/suppliers/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updatesupplier(Supplier supplier){
		supplierService.save(supplier);
		return "redirect:/suppliers";
	     }
	
	@RequestMapping(value = "/suppliers/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deletesupplier(int id){
		supplierService.delete(id);
		return "redirect:/suppliers";
	     }
}
