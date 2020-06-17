package com.akcreations.springwebservice.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	@Autowired
	UserDaoService userService;
	
	
	 @GetMapping(path="/users")
	 public List<User> getListofUsers()
	 {
		return userService.findAllUsers(); 
	 }
	 
	 @GetMapping(path="/users/{userId}")
	 public User getUserById(@PathVariable Integer userId)
	 {
		 return userService.getUser(userId);
	 }
	 
	 @PostMapping(path="/users")
	 public ResponseEntity<Object> saveUser(@RequestBody User newUser)
	 {
		 User savedUser= userService.saveUser(newUser); 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		 .path("/{userId}").buildAndExpand(savedUser.getId()).toUri();
		 
		 return ResponseEntity.created(location).build();
	 }
	 
	 
}
