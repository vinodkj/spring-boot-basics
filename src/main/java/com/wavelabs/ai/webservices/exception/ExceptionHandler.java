package com.wavelabs.ai.webservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ExceptionHandler  extends ResponseEntityExceptionHandler{

	@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleExceptions(Exception ex,WebRequest request){
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionResponse(ex.getMessage(), request.getDescription(false)));
		
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	
	   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse("validation Error", ex.getBindingResult().getFieldError().getDefaultMessage()));
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest request){
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionResponse(ex.getMessage(), request.getDescription(false)));
		
	}
	

}
