package com.daily.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		Authentication auth =SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
		ModelAndView mv = new ModelAndView("redirect:/main.html");
		mv.addObject("name", name);
		return mv;
	}
	@RequestMapping(value="/facebook", method= RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadMainAfterFacebook(){
		log.info("inside loadMainAfterFacebook() method");
		ModelAndView mv = new ModelAndView("redirect:/main.html");
		return mv;
	}
	@RequestMapping("/linkedIn")
	@ResponseBody
	public ModelAndView loadMainAfterLinkedIn(){
		log.info("inside loadMainAfterLinkedIn() method");
		ModelAndView mv = new ModelAndView("redirect:/main.html");
		return mv;
	}
	@RequestMapping("/twitter")
	@ResponseBody
	public ModelAndView loadMainAfterTwitter(){
		log.info("inside loadMainAfterTwitter() method");
		ModelAndView mv = new ModelAndView("redirect:/main.html");
		return mv;
	}
	@RequestMapping(value="/registerurl" ,method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView loadRegister(){
		log.info("inside loadRegister() method");
		ModelAndView mv = new ModelAndView("redirect:/register.html");
		return mv;
	}
}
