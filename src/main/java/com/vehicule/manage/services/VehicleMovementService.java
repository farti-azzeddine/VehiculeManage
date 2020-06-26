package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.VehicleMovement;
import com.vehicule.manage.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {

	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;
	
//	return list of VehicleMovement 
	public List<VehicleMovement> getVehicleMovement(){
		return vehicleMovementRepository.findAll();
	}

	//save a new VehicleMovement
	public void save(VehicleMovement vehicleMovement) {
		vehicleMovementRepository.save(vehicleMovement);
	}
	
//	find country by id
	public Optional<VehicleMovement> findById(int id) {
		return vehicleMovementRepository.findById(id); 
	}

	public void delete(int id) {
		vehicleMovementRepository.deleteById(id);
		
	}
}