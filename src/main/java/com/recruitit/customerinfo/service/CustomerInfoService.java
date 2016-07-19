package com.recruitit.customerinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitit.customer.types.CustomerInfoCreateAndUpdateResponse;
import com.recruitit.customer.types.CustomerInfoCreateRequest;
import com.recruitit.customer.types.CustomerInfoDeleteResponse;
import com.recruitit.customer.types.CustomerInfoResponse;
import com.recruitit.customer.types.CustomerInfoUpdateRequest;
import com.recruitit.customerinfo.exception.CustomerNotFoundException;
import com.recruitit.customerinfo.model.Customer;
import com.recruitit.customerinfo.repository.CustomerRepository;

@Service
public class CustomerInfoService {

	@Autowired
	private CustomerRepository repository;
	
	public CustomerInfoResponse findById(String id) throws CustomerNotFoundException {
		return null;
	}
	
	public CustomerInfoCreateAndUpdateResponse create(CustomerInfoCreateRequest request) {
		return null;
	}
	
	public CustomerInfoCreateAndUpdateResponse update(String id, CustomerInfoUpdateRequest request) throws CustomerNotFoundException {
		return null;
	}
	
	public CustomerInfoDeleteResponse delete(String id) throws CustomerNotFoundException {
		return null;
	}
	
	private Customer customerRecordIntegrityCheck(String id) throws CustomerNotFoundException {
		Customer customer = repository.findOne(Long.parseLong(id));
		
		if(customer == null) {
			throw new CustomerNotFoundException("Customer not found in database");
		}
		
		return customer;
	}
}
