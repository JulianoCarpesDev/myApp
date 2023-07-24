package com.julianocarpes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MyExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MyExceptions(String msg) {
		super(msg);
	}
	
}
