package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.EmployeeType;
import com.vehicule.manage.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {

	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	
//	return list of employeeTypeRepository
	public List<EmployeeType> getEmployeeType(){
		return employeeTypeRepository.findAll();
	}

	//save a new state
	public void save(EmployeeType employeeType) {
		employeeTypeRepository.save(employeeType);
	}
	
//	find country by id
	public Optional<EmployeeType> findById(int id) {
		return employeeTypeRepository.findById(id); 
	}

	public void delete(int id) {
		employeeTypeRepository.deleteById(id);	
	}

}

