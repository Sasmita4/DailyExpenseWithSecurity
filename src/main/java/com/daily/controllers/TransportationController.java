package com.daily.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransportationController {

	@RequestMapping(value = {"/transportation" }, method = RequestMethod.GET)
	public String transportationPage(ModelMap model) {
		return "transportation";
	}
}
