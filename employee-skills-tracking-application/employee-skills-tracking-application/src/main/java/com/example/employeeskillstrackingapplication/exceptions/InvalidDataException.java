package com.example.employeeskillstrackingapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidDataException extends RuntimeException{
	
	private static final long serialVersionUID = 6974644855556556892L;
	
	
	public InvalidDataException(String message) {
		super(message);

	}


}