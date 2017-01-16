package com.daily.error;

import org.springframework.security.core.AuthenticationException;

/*
 * This exception will throw when user is trying to login but not authenticated
 */
public class UserNotActivatedException extends AuthenticationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5616341529860955083L;
	
	public UserNotActivatedException(String msg){
		super(msg);
	}
}
