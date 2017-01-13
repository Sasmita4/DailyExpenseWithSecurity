package com.daily.service;

import java.util.Locale;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.daily.dto.UsersDto;

@Service
@RefreshScope
public class MailService {
	Logger log = LoggerFactory.getLogger(MailService.class);
	
//	@Autowired
//	private MailSender mailSender;
//	private SimpleMailMessage simpleMailMessage;
	
	@Autowired
	private JavaMailSenderImpl javaMailSender;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private SpringTemplateEngine templateEngine;
	
	@Value("${send.from.email}")
	private String fromMail;
	
	@Autowired
	UserService userService;
	
	public void sendEmail(String to, String subject, String content){
		
		log.info("inside sendMail() method"); 
	    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	    try {
	        MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
	        message.setTo(to);
	        message.setFrom(fromMail);
	        message.setSubject(subject);
	        message.setText(content,true);
	        javaMailSender.send(mimeMessage);
	        log.debug("Sent e-mail to User '{}'", to);
	    } catch (Exception e) {
	        log.warn("E-mail could not be sent to user '{}', exception is: {}", to, e.getMessage());
	    }
	}
	
    public void sendActivationEmail(UsersDto user, String baseUrl) {
        log.debug("Sending activation e-mail to '{}'", user.getEmail());
        Context context = new Context();
        context.setVariable("user", user);
        context.setVariable("baseUrl", baseUrl);
        String content = templateEngine.process("activationEmail", context);
        String subject = "from DailyExpense";
        sendEmail(user.getEmail(), subject, content);
    }
}
