package com.hcl.schedule_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler
	public final ResponseEntity<Object> handleScheduleIdException(ScheduleIdException ex, WebRequest request){
		ScheduleIdExceptionResponse exceptionResponse=new ScheduleIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
//	@ControllerAdvice
//	@RestController
//	public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
//		
//		public final ResponseEntity<Object> handleTraineeIdException(TraineeIdException ex, WebRequest request){
//			TraineeIdExceptionResponse exceptionResponse = new TraineeIdExceptionResponse(ex.getMessage());
//			return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
//			}

	
	
	
}
