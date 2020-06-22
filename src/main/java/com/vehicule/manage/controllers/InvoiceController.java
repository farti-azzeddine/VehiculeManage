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

import com.vehicule.manage.models.*;
import com.vehicule.manage.services.*;

@Controller
public class InvoiceController {
	
	
	@Autowired InvoiceStatutService invoiceStatutService;
	@Autowired ClientService clientService;
	@Autowired InvoiceService invoiceService;
	
	@GetMapping("/invoices")
	public String getinvoices(Model model) {
        Invoice b;
		
		model.addAttribute("invoicesList", invoiceService.getInvoice());
		model.addAttribute("clientList", clientService.getClient());
		model.addAttribute("invoicestatutList", invoiceStatutService.getInvoiceStatus());
		
		return "Invoice";
	}

	@PostMapping("/addNewInvoice")
	public String addinvoice(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping("/invoices/findByid")
	@ResponseBody
	
	public Optional<Invoice> findbyid(int id) {
		
		
		return invoiceService.findById(id);
	}
	
	@RequestMapping(value = "/invoices/update" , method = {RequestMethod.PUT , RequestMethod.GET})
	public String updateinvoice(Invoice invoice){
		invoiceService.save(invoice);
		return "redirect:/invoices";
	     }
	
	@RequestMapping(value = "/invoices/delete" , method = {RequestMethod.DELETE , RequestMethod.GET})
	public String deleteinvoice(int id){
		invoiceService.delete(id);
		return "redirect:/invoices";
	     }

}
