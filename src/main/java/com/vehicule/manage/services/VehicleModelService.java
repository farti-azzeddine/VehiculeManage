package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.VehicleModel;
import com.vehicule.manage.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	
//	return list of vehicleModelService 
	public List<VehicleModel> getVehicleModel(){
		return vehicleModelRepository.findAll();
	}

	//save a new state
	public void save(VehicleModel vehicleModel) {
		vehicleModelRepository.save(vehicleModel);
	}
	
//	find country by id
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelRepository.findById(id); 
	}

	public void delete(int id) {
		vehicleModelRepository.deleteById(id);	
	}

}