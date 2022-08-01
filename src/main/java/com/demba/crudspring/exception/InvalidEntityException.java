package com.demba.crudspring.exception;

import java.util.List;

import lombok.Getter;

public class InvalidEntityException extends RuntimeException {
	@Getter
	private ErrorCodes errorCode;
	@Getter
	private List<String> errors;
	
	public InvalidEntityException(String message) {
		super(message);
	}
	public InvalidEntityException(String message,Throwable cause) {
		super(message,cause);
	}
	public InvalidEntityException(String message,Throwable cause, ErrorCodes errorcode) {
		super(message,cause);
		this.errorCode = errorcode;
	
	}
	public InvalidEntityException(String message, ErrorCodes errorcode) {
		super(message);
		this.errorCode = errorcode;
	}

	public InvalidEntityException(String message, ErrorCodes errorcode,List<String> errors) {
		super(message);
		this.errorCode = errorcode;
		this.errors = errors;
		
	}
}
