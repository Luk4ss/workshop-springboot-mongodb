package com.lucas.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.workshopmongo.domain.User;
import com.lucas.workshopmongo.dto.UserDTO;
import com.lucas.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> userList = userService.findAll();
		List<UserDTO> userListDto = userList.stream().map(user -> new UserDTO(user)).toList();
		
		return ResponseEntity.ok().body(userListDto);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		 User user = userService.findById(id);
		 UserDTO userdto = new UserDTO(user);
		 return ResponseEntity.ok().body(userdto);
		
	}
	


}
