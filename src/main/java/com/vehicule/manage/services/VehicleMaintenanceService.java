package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.VehicleMaintenance;
import com.vehicule.manage.repositories.VehicleMaintenanceRepository;

@Service
public class VehicleMaintenanceService {


	@Autowired
	private VehicleMaintenanceRepository vehicleMaintenanceRepository;
	
//	return list of VehicleMaintenance 
	public List<VehicleMaintenance> getVehicleMaintenance(){
		return vehicleMaintenanceRepository.findAll();
	}

	//save a new VehicleMaintenance
	public void save(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceRepository.save(vehicleMaintenance);
	}
	
//	find country by id
	public Optional<VehicleMaintenance> findById(int id) {
		return vehicleMaintenanceRepository.findById(id); 
	}

	public void delete(int id) {
		vehicleMaintenanceRepository.deleteById(id);
		
	}
}
