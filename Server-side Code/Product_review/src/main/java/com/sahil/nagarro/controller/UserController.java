package com.sahil.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.nagarro.models.*;

import com.sahil.nagarro.services.Userservice;




@RestController
@CrossOrigin("*")
public class UserController {
	
	
	@Autowired
	private  Userservice service;
	
	int login=0;

	
	@GetMapping("/login/{email}")
	public User findUser( @PathVariable String email )
	{
     User user = service.findByEmail(email);
     login++;
  if(user!=null)
 	{
 	return user;
 	}
 	
 	return new User(-1,null,null,null,null);
 	
	}
	


	@PostMapping("/register")
	public String saveuser(@RequestBody User user)
	{
		this.service.adduser(user);
        return (user.getFname()+""+user.getLname()+" "+"you got Registered Successfully!!");
	
	}
	
	@GetMapping("/nouser")
	public int usercount()
	{
		return this.service.countuser();
		
		
	}
	
	
	
	
	
 
}

