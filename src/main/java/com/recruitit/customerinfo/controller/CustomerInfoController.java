package com.recruitit.customerinfo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruitit.customer.types.CustomerInfoCreateAndUpdateResponse;
import com.recruitit.customer.types.CustomerInfoCreateRequest;
import com.recruitit.customer.types.CustomerInfoDeleteResponse;
import com.recruitit.customer.types.CustomerInfoResponse;
import com.recruitit.customer.types.CustomerInfoUpdateRequest;
import com.recruitit.customerinfo.exception.CustomerNotFoundException;

@RestController
@RequestMapping("customer")
public class CustomerInfoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerInfoController.class);

	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public HttpEntity<CustomerInfoResponse> find(
			@PathVariable String id) throws CustomerNotFoundException {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public HttpEntity<CustomerInfoCreateAndUpdateResponse> create(
			@Valid @RequestBody CustomerInfoCreateRequest request) {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public HttpEntity<CustomerInfoCreateAndUpdateResponse> update(
			@PathVariable String id,
			@Valid @RequestBody CustomerInfoUpdateRequest request) 
			throws CustomerNotFoundException {
		return null;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public HttpEntity<CustomerInfoDeleteResponse> delete(
			@PathVariable String id) throws CustomerNotFoundException {
		return null;
	}
	
	private static String logPayload(Object o) {
		try {
			return objectMapper.writeValueAsString(o);
		} catch(JsonProcessingException e) {
			LOGGER.error("Cannot log payload", e);
			return null;
		}
	}
}
