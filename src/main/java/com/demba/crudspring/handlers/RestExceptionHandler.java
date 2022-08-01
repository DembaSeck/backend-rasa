package com.demba.crudspring.handlers;
import com.demba.crudspring.exception.EntityNotFoundException;
import com.demba.crudspring.exception.InvalidEntityException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice 
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
@ExceptionHandler(EntityNotFoundException.class)
public ResponseEntity<ErrorDto> HandleException(EntityNotFoundException exception ,WebRequest webRequest){
 
	final HttpStatus notFound = HttpStatus.NOT_FOUND;
	final ErrorDto errorDto= ErrorDto.builder()
		.code(exception.getErrorCode())
		.httpCode(notFound.value())
		.message(exception.getMessage())
		.build();
	
	return new ResponseEntity<>(errorDto,notFound);
	
	
 }
@ExceptionHandler(InvalidEntityException.class)
public ResponseEntity<ErrorDto> HandleException(InvalidEntityException exception ,WebRequest webRequest){
	
	final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
	final ErrorDto errorDto= ErrorDto.builder()
	.code(exception.getErrorCode())
	.httpCode(badRequest.value())
	.message(exception.getMessage())
	.errors(exception.getErrors())
	.build();

return new ResponseEntity<>(errorDto,badRequest);
	
	
}


}
