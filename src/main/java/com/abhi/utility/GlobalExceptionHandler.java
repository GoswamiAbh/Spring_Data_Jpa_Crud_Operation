package com.abhi.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleException(MethodArgumentNotValidException ex){
		Map<String, String> errMsg = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errMsg.put(error.getField(), error.getDefaultMessage());
			});
		return new ResponseEntity<>(errMsg,HttpStatus.BAD_REQUEST);
		
	}

}

