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

import com.vehicule.manage.models.JobTitle;
import com.vehicule.manage.services.JobTtitleService;

@Controller
public class JobTitleController {
	
     @Autowired JobTtitleService jobTitleService;

     @GetMapping("/jobTitles")
     public String getjobTitles(Model model) {

    
	List<JobTitle> jobTitleList = jobTitleService.getJobTitle();
	model.addAttribute("jobtitleList", jobTitleList);
	return "JobTitle";
}

@PostMapping("/addNewJobTitle")
public String addlocation(JobTitle jobTitle) {
	jobTitleService.save(jobTitle);
	return "redirect:/jobTitles";
}

@RequestMapping("/jobTitle/findByid")
@ResponseBody
public Optional<JobTitle> findbyid(int id) {

	return jobTitleService.findById(id);
}

@RequestMapping(value = "/jobTitle/update" , method = {RequestMethod.PUT , RequestMethod.GET})
public String updatestate(JobTitle jobTitle){
	jobTitleService.save(jobTitle);
	return "redirect:/jobTitles";
     }

@RequestMapping(value = "/jobTitle/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
public String deletejobTitles(int id){
	jobTitleService.delete(id);
	return "redirect:/jobTitles";
     }
}
