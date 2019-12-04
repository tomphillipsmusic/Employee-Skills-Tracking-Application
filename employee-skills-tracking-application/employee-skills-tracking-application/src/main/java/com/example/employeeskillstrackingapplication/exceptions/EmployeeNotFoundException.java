package com.example.employeeskillstrackingapplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 6974644855556556894L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
