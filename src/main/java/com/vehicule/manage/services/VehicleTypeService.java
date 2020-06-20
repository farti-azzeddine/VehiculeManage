package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.VehicleType;
import com.vehicule.manage.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	
//	return list of vehicleTypeService 
	public List<VehicleType> getVehicleType(){
		return vehicleTypeRepository.findAll();
	}

	//save a new state
	public void save(VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
	}
	
//	find country by id
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeRepository.findById(id); 
	}

	public void delete(int id) {
		vehicleTypeRepository.deleteById(id);	
	}

}