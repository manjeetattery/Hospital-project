package com.example.excption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(UserNotFoundException.class)
	 @ResponseBody
	    public ResponseEntity<ApiResponse> handleProductNotFoundException(UserNotFoundException e) {
		 
		 ApiResponse apiResponse = new ApiResponse(e.getMessage(), "90008");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	            .body(apiResponse);
	    }
}
class ApiResponse {
	
	private String message;
	private String code;
	
	
	public ApiResponse(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}