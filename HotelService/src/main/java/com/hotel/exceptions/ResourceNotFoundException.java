package com.hotel.exceptions;


public class ResourceNotFoundException extends RuntimeException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg){
		super(msg);
	}
	
	public ResourceNotFoundException(){
		super("Resource Not Found");
	}
	

}
