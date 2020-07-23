package com.vehicule.manage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.User;
import com.vehicule.manage.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
//	return list of User 
	public List<User> getUser(){
		return userRepository.findAll();
	}

//  save a new User
	public void save(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		userRepository.save(user);
	}
	
//	find country by id
	public Optional<User> findById(int id) {
		return userRepository.findById(id); 
	}

	public void delete(int id) {
		userRepository.deleteById(id);
		
	}
}
