package com.daily.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DailyExpenseTrackerController {
	
	@RequestMapping("/home")
	@ResponseBody
	public ModelAndView loadMain(){
		ModelAndView mv=new ModelAndView("redirect:/main.html");
		return mv;
	}
}
