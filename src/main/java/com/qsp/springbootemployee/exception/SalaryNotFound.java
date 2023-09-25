package com.qsp.springbootemployee.exception;

public class SalaryNotFound extends RuntimeException{
	
private String message;
	
	@Override
	public String getMessage() {
		
		return message;
	}

	public SalaryNotFound(String message) {
		super();
		this.message = message;
	}

}
