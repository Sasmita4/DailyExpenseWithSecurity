package com.daily.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private final Logger log = LoggerFactory.getLogger(LoginController.class);
	   @RequestMapping(value = {"/accessdenied" }, method = RequestMethod.GET)
	 		public ModelAndView errorPage(ModelMap model) {
	 		   ModelAndView mv=new ModelAndView("accessdenied.html");
	 		   return mv;
	 		}
}
