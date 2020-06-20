package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.VehicleStatus;
import com.vehicule.manage.repositories.VehicleStatusRepository;;

@Service
public class VehicleStatutService {

	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;
	
	
//	return list of vehicleMakeService 
	public List<VehicleStatus> getVehicleStatus(){
		return vehicleStatusRepository.findAll();
	}

	//save a new state
	public void save(VehicleStatus vehicleStatus) {
		vehicleStatusRepository.save(vehicleStatus);
	}
	
//	find country by id
	public Optional<VehicleStatus> findById(int id) {
		return vehicleStatusRepository.findById(id); 
	}

	public void delete(int id) {
		vehicleStatusRepository.deleteById(id);	
	}

}
