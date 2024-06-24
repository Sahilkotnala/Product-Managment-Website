package com.sahil.nagarro.repositary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sahil.nagarro.models.User;

public interface Userrepositary extends JpaRepository<User, Integer> {
	
	
	User findByEmail(String email);

	@Query("select COUNT(*) from User")
	int countuser();


	
}
