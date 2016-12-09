package com.daily.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {
	
	@RequestMapping(value = {"/food" }, method = RequestMethod.GET)
	public String foodPage(ModelMap model) {
		return "food";
	}

}
