package com.daily.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyExpenseTrackerController {
	
	@RequestMapping("/home")
	public String homePage(){
		
		
	 return "index";
	}

}
