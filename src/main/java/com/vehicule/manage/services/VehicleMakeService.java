package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.VehicleMake;
import com.vehicule.manage.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {
	
	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;
	
	
//	return list of vehicleMakeService 
	public List<VehicleMake> getVehicleMake(){
		return vehicleMakeRepository.findAll();
	}

	//save a new state
	public void save(VehicleMake vehicleMake) {
		vehicleMakeRepository.save(vehicleMake);
	}
	
//	find country by id
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeRepository.findById(id); 
	}

	public void delete(int id) {
		vehicleMakeRepository.deleteById(id);	
	}

}
