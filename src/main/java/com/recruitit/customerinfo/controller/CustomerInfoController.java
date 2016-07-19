package com.recruitit.customerinfo.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.recruitit.customerinfo.service.CustomerInfoService;

@RestController
@RequestMapping("customer")
public class CustomerInfoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerInfoController.class);

	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private CustomerInfoService service;
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public HttpEntity<CustomerInfoResponse> find(
			@PathVariable String id) throws CustomerNotFoundException {
		String referenceId = UUID.randomUUID().toString();
		MDC.put("referenceId", referenceId);
		
		LOGGER.info("REQUEST PAYLOAD {} ", id);
		LOGGER.info("Find customer ID");
		
		CustomerInfoResponse response = service.findById(id);
		response.setReferenceId(referenceId);
		
		LOGGER.info("RESPONSE PAYLOAD {} ", logPayload(response));
		
		MDC.remove("referenceId");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public HttpEntity<CustomerInfoCreateAndUpdateResponse> create(
			@Valid @RequestBody CustomerInfoCreateRequest request) {
		String referenceId = UUID.randomUUID().toString();
		MDC.put("referenceId", referenceId);
		
		LOGGER.info("REQUEST PAYLOAD {} ", logPayload(request));
		LOGGER.info("Creating new customer");
		
		CustomerInfoCreateAndUpdateResponse response = service.create(request);
		response.setReferenceId(referenceId);
		
		LOGGER.info("RESPONSE PAYLOAD {} ", logPayload(response));
		
		MDC.remove("referenceId");
	
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public HttpEntity<CustomerInfoCreateAndUpdateResponse> update(
			@PathVariable String id,
			@Valid @RequestBody CustomerInfoUpdateRequest request) 
			throws CustomerNotFoundException {
		String referenceId = UUID.randomUUID().toString();
		MDC.put("referenceId", referenceId);
		
		LOGGER.info("REQUEST PAYLOAD {} " + id + " ", logPayload(request));
		LOGGER.info("Updating customer");
		
		CustomerInfoCreateAndUpdateResponse response = service.update(id, request);
		response.setReferenceId(referenceId);
		
		LOGGER.info("RESPONSE PAYLOAD {} ", logPayload(response));
		
		MDC.remove("referenceId");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public HttpEntity<CustomerInfoDeleteResponse> delete(
			@PathVariable String id) throws CustomerNotFoundException {
		String referenceId = UUID.randomUUID().toString();
		MDC.put("referenceId", referenceId);
		
		LOGGER.info("REQUEST PAYLOAD {} ", id);
		LOGGER.info("Deleting customer");
		
		CustomerInfoDeleteResponse response = service.delete(id);
		response.setReferenceId(referenceId);
		
		MDC.remove("referenceId");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
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
