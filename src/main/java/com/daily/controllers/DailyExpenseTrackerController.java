package com.daily.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DailyExpenseTrackerController {
	
	@RequestMapping("/home")
	@ResponseBody
	public ModelAndView homePage(){		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("test");
		
	 return mv;
	}


}
