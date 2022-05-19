package com.hcl.training_management.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TraineeIdException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TraineeIdException() {
		super();
		}

		public TraineeIdException(String errMsg) {
		super(errMsg);
		}



		}


