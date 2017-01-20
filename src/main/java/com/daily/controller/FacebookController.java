//package com.daily.controller;
//
//import javax.inject.Inject;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.social.facebook.api.Facebook;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class FacebookController {
//	Logger log = LoggerFactory.getLogger(FacebookController.class);
//
//	  private Facebook facebook;
//
//	    @Inject
//	    public FacebookController(Facebook facebook) {
//	        this.facebook = facebook;
//	    }
//
//	    @RequestMapping(method=RequestMethod.GET)
//	    public String helloFacebook(Model model) {
//	        return "redirect:/connect/facebook";

//	    }
//
//}
