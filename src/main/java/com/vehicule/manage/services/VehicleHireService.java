package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.VehicleHire;
import com.vehicule.manage.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {

	@Autowired
	private VehicleHireRepository vehicleHireRepository;
	
//	return list of VehicleHire 
	public List<VehicleHire> getVehicleHire(){
		return vehicleHireRepository.findAll();
	}

	//save a new VehicleHire
	public void save(VehicleHire vehicleHire) {
		vehicleHireRepository.save(vehicleHire);
	}
	
//	find country by id
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireRepository.findById(id); 
	}

	public void delete(int id) {
		vehicleHireRepository.deleteById(id);
		
	}
}
