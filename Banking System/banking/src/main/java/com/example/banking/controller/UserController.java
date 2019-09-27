package com.example.banking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.example.banking.model.User;
import com.example.banking.service.UserService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


@RestController
@CrossOrigin(origins="http://localhost:4200")  
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	
	  @GetMapping("/users")  
	    public List<User> allUsers() {  
	         return userService.getUsers();  
	          
	    }  
	  
	  @GetMapping("/user/{id}")  
	    public List<User> alluserByID(@PathVariable("id") Long id) {  
	         
	         return userService.getUserByID(id);  
	          
	    }  
	  
	  @RequestMapping(value = "/upuser/{id}", method = RequestMethod.PUT, produces = "application/json")
	  public User updateUser(@PathVariable(value = "id") Long id,
	                                          @Valid @RequestBody User userDetails) {

	    return userService.updateUser(id, userDetails);
	  }
	  
	  
//	  @RequestMapping(value = "/upuserBalance/{id}", method = RequestMethod.PUT, produces = "application/json")
//	  public User updateUserBalance(@PathVariable(value = "id") Long id,
//	                                          @Valid @RequestBody User userDetails,@Valid @RequestBody double amount) {
//
//	    return userService.updateUserBalance(id, userDetails,amount);
//	  }
	  
	  
	  @RequestMapping(value = "/upuserBalance/{id}/{amount}", method = RequestMethod.PUT, produces = "application/json")
	  public User updateUserBalance(@PathVariable(value = "id") Long id,
			  												@PathVariable("amount") double amount,
			  												@Valid @RequestBody User userDetails) {
		  
		  return userService.updateUserBalance(id,amount,userDetails);
	  }
	  
	  
	  @RequestMapping(value = "/transfer/{id}/{id2}/{amount}", method = RequestMethod.PUT, produces = "application/json")
	  public User updateUsersForTransfer(@PathVariable(value = "id") Long id,
			  												@PathVariable(value = "id2") Long id2,
			  												@PathVariable("amount") double amount,
			  												@Valid @RequestBody User userDetails) {
		  
		  return userService.updateUsersForTransfer(id,id2,amount,userDetails);
	  }
	  
	  
	  
	  @PostMapping("/login")
		public ResponseEntity<User> login(@RequestBody User user){
			return userService.login(user);
		}
		
	  
	

}
