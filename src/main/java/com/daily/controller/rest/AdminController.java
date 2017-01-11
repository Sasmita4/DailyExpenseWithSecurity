package com.daily.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daily.dto.UsersDto;
import com.daily.service.UserService;

@RestController
public class AdminController {
	Logger Log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	UserService userService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/getAllUsers" , method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UsersDto>> getAllUsers(){
		List<UsersDto> userDtoList = new ArrayList<UsersDto>();
		try{
			userDtoList = userService.getUsers();
		}catch(Exception ex){
			
		}
		return new ResponseEntity<List<UsersDto>>(userDtoList, HttpStatus.OK);
	}
}
