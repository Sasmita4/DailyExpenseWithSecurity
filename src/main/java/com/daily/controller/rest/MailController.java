package com.daily.controller.rest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daily.dto.UsersDto;
import com.daily.service.MailService;
import com.daily.service.UserService;

@RestController
@RefreshScope
public class MailController {
	Logger log = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	private MailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	
	@Value("${send.from.email}")
	private String fromMail;
	
	@Value("${send.to.email}")
	private String toMail;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MailService mailService;
	
	@RequestMapping("/sendEmail")
	public String sendMail(Model model){
		log.info("inside sendMail() method"); 
		String response = "OK";
		this.simpleMailMessage = new SimpleMailMessage();
		this.simpleMailMessage.setSubject("Daily expense tracker");
		this.simpleMailMessage.setTo(toMail);
		this.simpleMailMessage.setFrom(fromMail);
		
		SimpleMailMessage finalMessage = new SimpleMailMessage(this.simpleMailMessage);
		finalMessage.setText("Message from daily expense tracker");
		try{
			this.mailSender.send(finalMessage);
		}catch(MailException ex){
 			response = "NO_OK";
		}
		return response;
	}
}
