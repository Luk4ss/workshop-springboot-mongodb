package com.lucas.workshopmongo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.workshopmongo.domain.User;
import com.lucas.workshopmongo.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		List<User> userList = new ArrayList<>();
		userList = userRepository.findAll();
		return userList;
		
	}
	



}
