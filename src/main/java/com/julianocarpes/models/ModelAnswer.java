package com.julianocarpes.models;

import org.springframework.stereotype.Component;

@Component

public class ModelAnswer {
	 
	public String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
