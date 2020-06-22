package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.Client;
import com.vehicule.manage.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
//	return list of Client 
	public List<Client> getClient(){
		return clientRepository.findAll();
	}

	//save a new Client
	public void save(Client client) {
		clientRepository.save(client);
	}
	
//	find country by id
	public Optional<Client> findById(int id) {
		return clientRepository.findById(id); 
	}

	public void delete(int id) {
		clientRepository.deleteById(id);
		
	}
}

