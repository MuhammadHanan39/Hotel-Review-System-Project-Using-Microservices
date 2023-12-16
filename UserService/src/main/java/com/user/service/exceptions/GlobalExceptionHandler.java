package com.user.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {



	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> userNotFoundException(ResourceNotFoundException e){
		
		e.printStackTrace();
		
		ApiResponse apiResponse = ApiResponse.builder().msg(e.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
		
		
		
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
		
		
		
		
		
	}
}
