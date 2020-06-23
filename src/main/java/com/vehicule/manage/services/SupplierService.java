package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.Supplier;
import com.vehicule.manage.repositories.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
//	return list of Supplier 
	public List<Supplier> getSupplier(){
		return supplierRepository.findAll();
	}

	//save a new Supplier
	public void save(Supplier supplier) {
		supplierRepository.save(supplier);
	}
	
//	find country by id
	public Optional<Supplier> findById(int id) {
		return supplierRepository.findById(id); 
	}

	public void delete(int id) {
		supplierRepository.deleteById(id);
		
	}
}
