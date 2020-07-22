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

import com.vehicule.manage.models.User;
import com.vehicule.manage.services.UserService;
import com.vehicule.manage.services.CountryService;
import com.vehicule.manage.services.StateService;

@Controller
public class UserController {
	
	@GetMapping("/users")
	public String getCountries() {
		return "User";
	}

//	@Autowired UserService userService;
//	
//	@GetMapping("/users")
//	public String getusers(Model model) {
//        User b;
//        
//		
//		model.addAttribute("usersList", userService.getUser());
//		return "User";
//	}
//
//	@PostMapping("/addNewUser")
//	public String adduser(User user) {
//		userService.save(user);
//		return "redirect:/users";
//	}
//	
//	@RequestMapping("/users/findByid")
//	@ResponseBody
//	
//	public Optional<User> findbyid(int id) {
//		
//		
//		return userService.findById(id);
//	}
//	
//	@RequestMapping(value = "/users/update" , method = {RequestMethod.PUT , RequestMethod.GET})
//	public String updateuser(User user){
//		userService.save(user);
//		return "redirect:/users";
//	     }
//	
//	@RequestMapping(value = "/users/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
//	public String deleteuser(int id){
//		userService.delete(id);
//		return "redirect:/users";
//	     }
}
