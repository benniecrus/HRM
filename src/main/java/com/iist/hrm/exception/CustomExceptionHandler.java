package com.iist.hrm.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StringBuilder message = new StringBuilder();
        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
        	message.append(error.getDefaultMessage() + " ");
        }
        ErrorResponse error = new ErrorResponse(message.toString(), "");
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PositionNotFoundException.class)
	public ResponseEntity<Object> handlePositionNotFoundException(PositionNotFoundException ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse(ex.getMessage(), "");
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<Object> handleProduct(ProductException ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse(ex.getMessage(), "");
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
}
