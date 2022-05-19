package com.hcl.calendarmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CalendarIdException extends RuntimeException{
	
	private static final long serialVersionUID=1l;

	public CalendarIdException() {
		super();
		
	}
	public CalendarIdException(String errorMes) {
		super(errorMes );
		
	}
	
	

}
