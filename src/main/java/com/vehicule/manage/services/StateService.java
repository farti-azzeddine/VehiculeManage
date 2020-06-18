package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.Country;
import com.vehicule.manage.models.State;
import com.vehicule.manage.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
//	return list of state 
	public List<State> getState(){
		return stateRepository.findAll();
	}

	//save a new state
	public void save(State state) {
		stateRepository.save(state);
	}
	
//	find country by id
	public Optional<State> findById(int id) {
		return stateRepository.findById(id); 
	}

	public void delete(int id) {
		stateRepository.deleteById(id);
		
	}
}
