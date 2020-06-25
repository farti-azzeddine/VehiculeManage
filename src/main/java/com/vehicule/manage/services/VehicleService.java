package com.vehicule.manage.services;

import java.util.List;

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
	
}
