package com.hcl.schedule_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ScheduleIdException extends RuntimeException {

	private static final long serialVersionUID= 1L;
	
	public ScheduleIdException() {
		super();
		
	}
	
	public ScheduleIdException(String errMsg) {
		super(errMsg);
		
	}
	
}
