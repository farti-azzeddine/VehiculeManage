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

import com.vehicule.manage.models.InvoiceStatus;
import com.vehicule.manage.services.InvoiceStatutService;

@Controller
public class InvoiceStatusController {
	
	
@Autowired InvoiceStatutService invoiceStatutService;
	
	@GetMapping("/invoiceStatuses")
	public String getinvoiceStatus(Model model) {
		
        
		List<InvoiceStatus> invoiceStatusList = invoiceStatutService.getInvoiceStatus();
		model.addAttribute("invoicestatusList", invoiceStatusList);
		return "InvoiceStatus";
	}

	@PostMapping("/addNewInvoiceStatuses")
	public String addinvoiceStatus(InvoiceStatus invoiceStatus) {
		invoiceStatutService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	
	@RequestMapping("/invoiceStatuses/findByid")
	@ResponseBody
	public Optional<InvoiceStatus> findbyid(int id) {
	
		return invoiceStatutService.findById(id);
	}
	
	@RequestMapping(value = "/invoiceStatuses/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updateinvoiceStatus(InvoiceStatus invoiceStatus){
		invoiceStatutService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	     }
	
	@RequestMapping(value = "/invoiceStatuses/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deleteinvoiceStatus(int id){
		invoiceStatutService.delete(id);
		return "redirect:/invoiceStatuses";
	     }
}

