package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.Contact;
import com.vehicule.manage.repositories.ContactRepository;

@Service
public class ContactService {


	@Autowired
	private ContactRepository contactRepository;
	
//	return list of Contact 
	public List<Contact> getContact(){
		return contactRepository.findAll();
	}

	//save a new Contact
	public void save(Contact contact) {
		contactRepository.save(contact);
	}
	
//	find country by id
	public Optional<Contact> findById(int id) {
		return contactRepository.findById(id); 
	}

	public void delete(int id) {
		contactRepository.deleteById(id);
		
	}
}


