package com.daily.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DailyExpenseTrackerController {
	
	@RequestMapping("/home")
	@ResponseBody
	public ModelAndView loadMain(){
		ModelAndView mv=new ModelAndView("redirect:/main.html");
		return mv;
	}
	
	@RequestMapping(value = {"/food" }, method = RequestMethod.GET)
	public String foodPage(ModelMap model) {
		return "food";
	}

	@RequestMapping(value = {"/miscellaneous" }, method = RequestMethod.GET)
	public String miscellaneousPage(ModelMap model) {
		return "miscellaneous";
	}
	@RequestMapping(value = {"/transportation" }, method = RequestMethod.GET)
	public String transportationPage(ModelMap model) {
		return "transportation";
	}

	
}
