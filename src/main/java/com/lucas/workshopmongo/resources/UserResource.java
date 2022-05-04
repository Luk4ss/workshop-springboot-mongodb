package com.lucas.workshopmongo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody UserDTO userDto){
		
		User user = userService.fromDTO(userDto);
		user = userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleById(@PathVariable String id){
		userService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<User> update(@RequestBody UserDTO userDto, @PathVariable String id){
		User user = userService.fromDTO(userDto);
		user.setId(id);
		user = userService.update(user);
		return ResponseEntity.noContent().build();
		
	}
	


}
