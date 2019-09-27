package com.example.banking.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.example.banking.model.User;
import com.fasterxml.jackson.databind.JsonNode;

public interface UserService {

	List<User> getUsers();

	User updateUser(Long id, @Valid User userDetails);

	User updateUserBalance(Long id, double amount, User userDetails);

	User updateUsersForTransfer(Long id, Long id2, double amount, @Valid User userDetails);

	ResponseEntity<User> login(User user);

	List<User> getUserByID(Long id);


//	User updateUserBalance(Long id, @Valid User userDetails, @Valid double amount);

}
