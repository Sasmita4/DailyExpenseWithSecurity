package com.daily.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalDailyExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(GlobalDailyExceptionHandler.class);
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="bad request")
	@ExceptionHandler(CommonException.class)
	public void handleCommonException(){
		logger.error("commonException handler executed");
	}

}
