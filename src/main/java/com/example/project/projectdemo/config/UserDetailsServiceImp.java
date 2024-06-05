package com.example.project.projectdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.project.projectdemo.model.User;
import com.example.project.projectdemo.repository.UserRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	UserRepository urepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = urepo.findUserByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found by such :"+username);
		}
		return user;
	}

}
