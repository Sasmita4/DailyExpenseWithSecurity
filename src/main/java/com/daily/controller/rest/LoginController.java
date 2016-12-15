package com.daily.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daily.domain.Users;
import com.daily.repository.UsersRepository;

@RequestMapping("/api")
@RestController
public class LoginController {
	private final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UsersRepository usersRepository;
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public void loginVerification(String  userName, String password){
		Users user = usersRepository.findByUserName(userName);
		if(userName.equalsIgnoreCase(user.getUserName()) && password.equals(user.getPassword())){
			
		}
		else{
			
		}
		
	}

}
