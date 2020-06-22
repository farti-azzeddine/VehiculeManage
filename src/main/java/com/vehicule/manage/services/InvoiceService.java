package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.Invoice;
import com.vehicule.manage.repositories.InvoiceRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	
//	return list of Invoice 
	public List<Invoice> getInvoice(){
		return invoiceRepository.findAll();
	}

	//save a new Invoice
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
//	find by id
	public Optional<Invoice> findById(int id) {
		return invoiceRepository.findById(id); 
	}

	public void delete(int id) {
		invoiceRepository.deleteById(id);
		
	}
}
