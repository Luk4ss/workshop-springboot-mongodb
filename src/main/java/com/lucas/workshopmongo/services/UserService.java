package com.lucas.workshopmongo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.workshopmongo.domain.User;
import com.lucas.workshopmongo.dto.UserDTO;
import com.lucas.workshopmongo.repositories.UserRepository;
import com.lucas.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		List<User> userList = new ArrayList<>();
		userList = userRepository.findAll();
		return userList;
		
	}
	
	public User findById(String id){
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public User insert(User user) {
		
		return userRepository.insert(user);
	}
	
	public void deleteById(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User user) {
		User new_user = findById(user.getId());
		updateData(new_user, user);
		
		return userRepository.save(new_user);
		
	}
	
	public void updateData(User new_user, User user) {
		new_user.setName(user.getName());
		new_user.setEmail(user.getEmail());
	}
	
	
	
	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
	
	



}
