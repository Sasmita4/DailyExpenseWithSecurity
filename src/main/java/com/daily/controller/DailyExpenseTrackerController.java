package com.daily.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.daily.service.UserService;

@Controller
public class DailyExpenseTrackerController {
	private final Logger log = LoggerFactory.getLogger(DailyExpenseTrackerController.class);
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/home")
	@ResponseBody
	public ModelAndView loadMain(){
		log.info("inside loadMain() method");
		ModelAndView mv = new ModelAndView("redirect:/main.html");
		return mv;
	}
}
