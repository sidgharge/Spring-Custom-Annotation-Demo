package com.bridgelabz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
@RequestMapping
public class ExceptionHandlerController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handle(MethodArgumentNotValidException e) {
		List<String> stringErrors = new ArrayList<>();
		List<ObjectError> errors = (e.getBindingResult().getAllErrors());
		for (ObjectError objectError : errors) {
			stringErrors.add(objectError.getDefaultMessage());
		}
		return new ResponseEntity<>(stringErrors, HttpStatus.BAD_REQUEST);
	}
}
