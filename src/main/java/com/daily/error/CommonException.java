package com.daily.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Not Found")
public class CommonException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7188745116726281725L;

	public CommonException(String msg){
		super("Not found"+msg);
	}
}
