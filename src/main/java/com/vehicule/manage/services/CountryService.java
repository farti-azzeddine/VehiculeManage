package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.Country;
import com.vehicule.manage.repositories.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
    //	return list of countries 
	public List<Country> getCountries(){
		return countryRepository.findAll();
	}
	
//	save a new country
	public void save(Country country) {
		
		countryRepository.save(country);
	}
	
    //	find country by id
	public Optional<Country> findById(int id) {
		return countryRepository.findById(id); 
	}

	public void delete(int id) {
		countryRepository.deleteById(id);
		
	}

}
