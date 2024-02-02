package com.hotel.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map> resourceNotFoundException(Exception e){
		
		Map result=new HashMap<>();
		result.put("msg", e.getMessage());
		result.put("status", "Not Found");
		result.put("success", false);
		
		
		
		
		
		
		return new ResponseEntity<Map>(result,HttpStatus.NOT_FOUND);
		
	}
	
	
	
}
