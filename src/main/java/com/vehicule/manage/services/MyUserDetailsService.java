package com.vehicule.manage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vehicule.manage.models.User;
import com.vehicule.manage.models.UserPrincipal;
import com.vehicule.manage.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired UserRepository  userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new UserPrincipal(user);
		
	}

}
