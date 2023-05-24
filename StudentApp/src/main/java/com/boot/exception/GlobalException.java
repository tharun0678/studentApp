package com.boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(StudentException ex){
		
		String message = ex.getMessage();
		
		ApiResponse api = new ApiResponse();
		
		api.setMessage(message);
		api.setStatus(false);
		
		return new ResponseEntity<ApiResponse>(api, HttpStatus.NOT_FOUND);
	}

}
