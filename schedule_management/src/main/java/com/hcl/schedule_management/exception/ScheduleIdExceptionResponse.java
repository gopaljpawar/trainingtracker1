package com.hcl.schedule_management.exception;

public class ScheduleIdExceptionResponse {

	private Long id;

	public ScheduleIdExceptionResponse(Long id) {
		super();
		this.id=id;
	}
	
	

	public ScheduleIdExceptionResponse(String msg) {
		super();
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	
}
