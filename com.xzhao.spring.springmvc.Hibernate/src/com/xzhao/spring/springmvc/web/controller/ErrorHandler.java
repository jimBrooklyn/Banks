package com.xzhao.spring.springmvc.web.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException e){
		return "error";
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public String handleAcessDeniedException(AccessDeniedException e){
		return "denied";
	}
}
