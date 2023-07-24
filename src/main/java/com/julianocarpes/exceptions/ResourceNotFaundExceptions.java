package com.julianocarpes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFaundExceptions extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFaundExceptions(String msg) {
		super(msg);
	}
	
}
