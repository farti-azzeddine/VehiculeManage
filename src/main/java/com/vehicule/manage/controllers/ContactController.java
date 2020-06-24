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

import com.vehicule.manage.models.Contact;
import com.vehicule.manage.services.ContactService;
import com.vehicule.manage.services.CountryService;
import com.vehicule.manage.services.StateService;

@Controller
public class ContactController {

//	@GetMapping("/contacts")
//	public String GetContacts() {
//		return "Contact1";
//	}
//	
//	@Autowired StateService stateService;
//	@Autowired CountryService countryService;
	@Autowired ContactService contactService;
	
	@GetMapping("/contacts")
	public String getcontacts(Model model) {
        Contact b;
        
//		model.addAttribute("statetsList", stateService.getState());
//		model.addAttribute("countriesList", countryService.getCountries());
		model.addAttribute("contactsList", contactService.getContact());
		return "Contact1";
	}

	@PostMapping("/addNewContact")
	public String addcontact(Contact contact) {
		contactService.save(contact);
		return "redirect:/contacts";
	}
	
	@RequestMapping("/contacts/findByid")
	@ResponseBody
	
	public Optional<Contact> findbyid(int id) {
		
		
		return contactService.findById(id);
	}
	
	@RequestMapping(value = "/contacts/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updatecontact(Contact contact){
		contactService.save(contact);
		return "redirect:/contacts";
	     }
	
	@RequestMapping(value = "/contacts/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deletecontact(int id){
		contactService.delete(id);
		return "redirect:/contacts";
	     }
}
