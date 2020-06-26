package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.Vehicle;
import com.vehicule.manage.repositories.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
//	return list of Vehicle 
	public List<Vehicle> getVehicle(){
		return vehicleRepository.findAll();
	}
	

	//save a new Vehicle
	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
//	find country by id
	public Optional<Vehicle> findById(int id) {
		return vehicleRepository.findById(id); 
	}

	public void delete(int id) {
		vehicleRepository.deleteById(id);
		
	}
	
}
