package com.hcl.calendarmanagement.exception;

public class CalendarIdExceptionResponse {
	private String identifier;

	public CalendarIdExceptionResponse(String identifier) {
		super();
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

}
