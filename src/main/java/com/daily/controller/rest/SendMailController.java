package com.daily.controller.rest;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class SendMailController {
	Logger log = LoggerFactory.getLogger(SendMailController.class);
	
	@Autowired
	private MailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	
	@Value("${send.from.email}")
	private String fromMail;
	
	@Value("${send.to.email}")
	private String toMail;
	
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
