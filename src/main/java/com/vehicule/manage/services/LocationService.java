package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.Location;
import com.vehicule.manage.models.State;
import com.vehicule.manage.repositories.LocationRepository;
import com.vehicule.manage.repositories.StateRepository;

@Service
public class LocationService {
	
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private LocationRepository locationRepository;
	
//	return list of state 
	public List<Location> getLocation(){
		return locationRepository.findAll();
	}

	//save a new state
	public void save(Location location) {
		locationRepository.save(location);
	}
	
//	find country by id
	public Optional<Location> findById(int id) {
		return locationRepository.findById(id); 
	}

	public void delete(int id) {
		locationRepository.deleteById(id);	
	}

}
