package com.example.banking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.banking.model.User;




@Repository
public interface UserDAO extends JpaRepository<User, Long>{
	
	@Query("SELECT l FROM User l WHERE l.id = :id")
	User findforupdateUserById(@Param("id") Long id);
	
	
	
	@Query("select al from User al where email = ?1")
	Optional<User> findByEmail(String mail);
	
	
	@Query(value = "SELECT u FROM User u WHERE email = ?1")
	User login(String mail);
	
	
	@Query("SELECT p FROM User p WHERE p.id = :id")
	List<User> findUserById(@Param("id") Long id);

}
