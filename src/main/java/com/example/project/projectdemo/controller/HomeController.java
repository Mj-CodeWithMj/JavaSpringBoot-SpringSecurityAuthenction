package com.example.project.projectdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.projectdemo.model.User;
import com.example.project.projectdemo.repository.UserRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class HomeController {

	@Autowired
	UserRepository urepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
//    @PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/user/getData")
	public List<User> getUser() {
		List<User> user = urepo.findAll();
		 System.out.println(user);
		return user;
	}
//    @PreAuthorize("hasAuthority('USER')")
	@GetMapping("/user/getDataById/{id}")
	public Optional<User> getUserById(@PathVariable long id) {
		Optional<User> user = urepo.findById(id);
		return user;
	}
//	@GetMapping("/getDataById/{id}")
//	public Optional<User> getUsersById(@PathVariable long id) {
//		Optional<User> user = urepo.findById(id);
//		return user;
//	}
//	@PostMapping("/postData")
//	public User postData(@RequestBody User user) {
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		
//		return urepo.save(user);
//	}
	@PostMapping("/user/postDatas")
	public User save(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return urepo.save(user);
	}
	@PutMapping("/user/updateUser/{id}")
	public User updateUser(@PathVariable long id,@RequestBody User user) {
		user.setId(id);
		return urepo.save(user);
		
	}
	@DeleteMapping("/user/deleteUser/{id}")
	public void deleteUser(@PathVariable long id)  {
		urepo.deleteById(id);
	}
}
