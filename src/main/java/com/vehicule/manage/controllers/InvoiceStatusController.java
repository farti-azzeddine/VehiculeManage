package com.vehicule.manage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InvoiceStatusController {
	
	@GetMapping("/invoiceStatuses")
	public String getStates() {		
		
		return "InvoiceStatus";
	}	

}
