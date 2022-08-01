package com.demba.crudspring.exception;

public enum ErrorCodes {
	SPECIALITES_NOT_FOUND(1000),
	SPECIALITES_NOT_VALID(1001),
	
	RESPONSES_NOT_FOUND(2000),
	RESPONSES_NOT_VALID(2001),
	
	LIEUXES_NOT_FOUND(3000),
	LIEUXES_NOT_VALID(3001),
	
	Assureurs_Not_Found(4000),
	Assureurs_Not_Valid(4001),
	
	Users_Not_Found(5000),
	Users_Not_Valid(5001),
	//TODO COMPLETER LE RESTE DES CODES ERRORS....
	;
	
	private int code;
	
	ErrorCodes(int code){
		this.code = code;
	}
public int getCode() {
	return code;
}
}
