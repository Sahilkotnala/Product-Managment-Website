package com.sahil.nagarro.services;

import org.springframework.stereotype.Service;

import com.sahil.nagarro.repositary.Userrepositary;
import com.sahil.nagarro.models.User;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class Userservice {

@Autowired
private Userrepositary userrepo;


public User findByEmail(String email)
{
User isPresent = userrepo.findByEmail(email);

return isPresent;
}

public int countuser()
{
	return userrepo.countuser();
}


public User adduser(User user) {
	return userrepo.save(user);
}

}
