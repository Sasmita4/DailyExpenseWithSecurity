package com.daily.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.daily.dto.UsersDto;
import com.daily.service.MailService;
import com.daily.service.UserService;

@RestController
@RefreshScope
public class LoginController {
	private final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	MailService mailService;
	
	@Value("${send.from.email}")
	private String fromMail;
	
	@Value("${send.to.email}")
	private String toMail;
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView errorPage(ModelMap model) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String userName = auth.getName();
		ModelAndView mv = new ModelAndView("redirect:/invalidUser.html");
		mv.addObject("message", "sorry" +userName+" You don't have privileges to view this page!!!");
		return mv;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	   if (auth != null){    
	       new SecurityContextLogoutHandler().logout(request, response, auth);
	   }
	   return "success";
	}
	@RequestMapping("/registerUser")
	public  void registerUser(HttpServletRequest request){
	   UsersDto usersDto = new UsersDto();
	   usersDto.setEmail(toMail);
	   usersDto.setUserName("madhavi");
	   usersDto.setPassword("nisum");
	   UsersDto result = userService.registerUser(usersDto);
		String baseUrl = request.getScheme() +
				  		 "://"+
				  		 request.getServerName() +
				  		 ":"+
				  		 request.getServerPort() +
				  		 "/"+
				  		 request.getContextPath();
		
		mailService.sendActivationEmail(result, baseUrl);
	}
}
