package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.InvoiceStatus;
import com.vehicule.manage.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatutService {

	
	@Autowired
	private InvoiceStatusRepository InvoiceStatusRepository;
	
	
//	return list of InvoiceStatus 
	public List<InvoiceStatus> getInvoiceStatus(){
		return InvoiceStatusRepository.findAll();
	}

	//save a new 
	public void save(InvoiceStatus invoiceStatus) {
		InvoiceStatusRepository.save(invoiceStatus);
	}
	
//	find by id
	public Optional<InvoiceStatus> findById(int id) {
		return InvoiceStatusRepository.findById(id); 
	}

	public void delete(int id) {
		InvoiceStatusRepository.deleteById(id);	
	}

}

