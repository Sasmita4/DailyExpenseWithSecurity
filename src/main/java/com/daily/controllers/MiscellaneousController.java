package com.daily.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiscellaneousController {

	@RequestMapping(value = {"/miscellaneous" }, method = RequestMethod.GET)
	public String miscellaneousPage(ModelMap model) {
		return "miscellaneous";
	}
}
