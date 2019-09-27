package com.example.banking.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.banking.dao.UserDAO;
import com.example.banking.model.User;
import com.fasterxml.jackson.databind.JsonNode;


@Service("Service")  
@Transactional  
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}

	@Override
	public User updateUser(Long id, @Valid User userDetails) {
		User user =userDAO.findforupdateUserById(id);
        
	    user.setName(userDetails.getName());
	    user.setSurname(userDetails.getSurname());
	    user.setBalance(userDetails.getBalance());
	   
	    
	    
	    User updatednewUser = userDAO.save(user);
	    return updatednewUser;
	}

	@Override
	public User updateUserBalance(Long id, double amount, User userDetails) {
		User user =userDAO.findforupdateUserById(id);
        
	    user.setName(userDetails.getName());
	    user.setSurname(userDetails.getSurname());
	    user.setBalance(userDetails.getBalance()-amount);
	   
	    
	    
	    User updatednewUser = userDAO.save(user);
	    return updatednewUser;
	}

	@Override
	public User updateUsersForTransfer(Long id, Long id2, double amount, @Valid User userDetails) {
		User user1 =userDAO.findforupdateUserById(id);
		User user2=userDAO.findforupdateUserById(id2);
		
		user1.setName(userDetails.getName());
	    user1.setSurname(userDetails.getSurname());
	    user1.setBalance(userDetails.getBalance()-amount);
	    
	    user2.setName(user2.getName());
	    user2.setSurname(user2.getSurname());
	    user2.setBalance(user2.getBalance()+amount);
	    
	    User updatednewUser = userDAO.save(user1);
	    userDAO.save(user2);
	    return updatednewUser;
		
	}

	@Override
	public ResponseEntity<User> login(@RequestBody User user) {
		Optional<User> newUser = userDAO.findByEmail(user.getEmail());
		if(newUser.isPresent()) {
			if(StringUtils.equals(newUser.get().getPassword(), user.getPassword())) {
				return new ResponseEntity<User>(newUser.get(),HttpStatus.OK);
			}
		}
		return null;
	}

	@Override
	public List<User> getUserByID(Long id) {
		return userDAO.findUserById(id);
	}

	
	
	
	

//	@Override
//	public User updateUserBalance(Long id, @Valid User userDetails, @Valid double amount) {
//		
//		User user =userDAO.findforupdateUserById(id);
//		
//		user.setName(userDetails.getName());
//		user.setSurname(userDetails.getSurname());
//		user.setBalance(userDetails.getBalance()-amount);
//
//		User updatednewUser = userDAO.save(user);
//	    return updatednewUser;
//	}
	
	
	

	
	

}
