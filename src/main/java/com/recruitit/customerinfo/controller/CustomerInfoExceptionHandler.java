package com.recruitit.customerinfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.recruitit.customerinfo.exception.CustomerNotFoundException;
import com.recruitit.customerinfo.exception.ServiceExceptionDetail;

@ControllerAdvice
public class CustomerInfoExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerInfoExceptionHandler.class);
	
	private static final String NOT_FOUND = "RECRUITIT-404";
	private static final String BAD_REQUEST = "RECRUITIT-400";
	private static final String GENERAL_ERROR = "RECRUITIT-500";
	private static final String EXCEPTION_MESSAGE = "Something went wrong with your request. Please contact RecruitIT support.";
	
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseBody
	public ResponseEntity<ServiceExceptionDetail> customerNotFoundException(CustomerNotFoundException e) {
		ServiceExceptionDetail exception = new ServiceExceptionDetail(NOT_FOUND, EXCEPTION_MESSAGE);
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseBody
	public ResponseEntity<ServiceExceptionDetail> httpMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
		return badRequest();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<ServiceExceptionDetail> methodArgumentNotValidException(
			MethodArgumentNotValidException e) {
		return badRequest();
	}
	
	@ExceptionHandler(ServletRequestBindingException.class)
	@ResponseBody
	public ResponseEntity<ServiceExceptionDetail> servletRequestBindingException(
			ServletRequestBindingException e) {
		return badRequest();
	}
	
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public HttpEntity<ServiceExceptionDetail> handleHttpMessageNotReadableException(HttpMessageNotReadableException e){
		if (LOGGER.isErrorEnabled()) {
			LOGGER.error(e.getMessage());
		}
        return badRequest();
    }
    
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public HttpEntity<ServiceExceptionDetail> exception(Exception e) {
		Throwable cause = e.getCause();
		
		if (LOGGER.isErrorEnabled()) {
			LOGGER.error(e.getMessage());
		}

		ServiceExceptionDetail detail = new ServiceExceptionDetail();
		if(cause instanceof JsonParseException) {
			return badRequest();
		} else if(cause instanceof JsonProcessingException) {
			return badRequest();
		}
		
		detail.setCode(GENERAL_ERROR);
		detail.setDescription(EXCEPTION_MESSAGE);

		return new ResponseEntity<>(detail, HttpStatus.SERVICE_UNAVAILABLE);
	}
    
	private ResponseEntity<ServiceExceptionDetail> badRequest() {
		ServiceExceptionDetail exception = new ServiceExceptionDetail(BAD_REQUEST, EXCEPTION_MESSAGE);
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}

}
