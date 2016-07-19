package com.recruitit.customerinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recruitit.customer.types.Address;
import com.recruitit.customer.types.CustomerInfo;
import com.recruitit.customer.types.CustomerInfoCreateAndUpdateResponse;
import com.recruitit.customer.types.CustomerInfoCreateRequest;
import com.recruitit.customer.types.CustomerInfoDeleteResponse;
import com.recruitit.customer.types.CustomerInfoResponse;
import com.recruitit.customer.types.CustomerInfoUpdateRequest;
import com.recruitit.customer.types.Name;
import com.recruitit.customerinfo.exception.CustomerNotFoundException;
import com.recruitit.customerinfo.model.Customer;
import com.recruitit.customerinfo.repository.CustomerRepository;

@Service
public class CustomerInfoService {

	private static final int OPERATION_SUCCESSFUL = 0;
	
	@Autowired
	private CustomerRepository repository;
	
	public CustomerInfoResponse findById(String id) throws CustomerNotFoundException {
		Customer customer = customerRecordIntegrityCheck(id);
		
		CustomerInfoResponse response = new CustomerInfoResponse();
		response.setId(customer.getId());
		response.setAddress(new Address(customer.getHouseBrgy(), customer.getCity(), customer.getProvince()));
		response.setCustomerName(new Name(customer.getLastName(), customer.getFirstName(), customer.getMiddleName()));
		response.setTelephone(customer.getTelephone());
		
		return response;
	}
	
	public CustomerInfoCreateAndUpdateResponse create(CustomerInfoCreateRequest request) {
		Customer customer = new Customer();
		customer.setLastName(request.getCustomerName().getLastName());
		customer.setFirstName(request.getCustomerName().getFirstName());
		customer.setMiddleName(request.getCustomerName().getMiddleName());
		customer.setHouseBrgy(request.getAddress().getHouseBrgy());
		customer.setCity(request.getAddress().getCity());
		customer.setProvince(request.getAddress().getProvince());
		customer.setTelephone(request.getTelephone());
		
		Customer savedInfo = repository.save(customer);
		
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setId(savedInfo.getId());
		customerInfo.setCustomerName(new Name(savedInfo.getLastName(), savedInfo.getFirstName(), savedInfo.getMiddleName()));
		customerInfo.setAddress(new Address(savedInfo.getHouseBrgy(), savedInfo.getCity(), savedInfo.getProvince()));
		customerInfo.setTelephone(savedInfo.getTelephone());
		
		CustomerInfoCreateAndUpdateResponse response = new CustomerInfoCreateAndUpdateResponse();
		response.setCustomerInfo(customerInfo);
		response.setCode(OPERATION_SUCCESSFUL);
		response.setMessage("You have successfully created a customer");
		
		return response;
	}
	
	public CustomerInfoCreateAndUpdateResponse update(String id, CustomerInfoUpdateRequest request) throws CustomerNotFoundException {
		Customer customer = customerRecordIntegrityCheck(id);
		
		customer.setLastName(request.getCustomerName().getLastName());
		customer.setFirstName(request.getCustomerName().getFirstName());
		customer.setMiddleName(request.getCustomerName().getMiddleName());
		customer.setHouseBrgy(request.getAddress().getHouseBrgy());
		customer.setCity(request.getAddress().getCity());
		customer.setProvince(request.getAddress().getProvince());
		customer.setTelephone(request.getTelephone());
		
		Customer savedInfo = repository.save(customer);
		
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setId(savedInfo.getId());
		customerInfo.setCustomerName(new Name(savedInfo.getLastName(), savedInfo.getFirstName(), savedInfo.getMiddleName()));
		customerInfo.setAddress(new Address(savedInfo.getHouseBrgy(), savedInfo.getCity(), savedInfo.getProvince()));
		customerInfo.setTelephone(savedInfo.getTelephone());
		
		CustomerInfoCreateAndUpdateResponse response = new CustomerInfoCreateAndUpdateResponse();
		response.setCustomerInfo(customerInfo);
		response.setCode(OPERATION_SUCCESSFUL);
		response.setMessage("You have successfully updated a customer");
		
		return response;
	}
	
	public CustomerInfoDeleteResponse delete(String id) throws CustomerNotFoundException {
		Customer customer = customerRecordIntegrityCheck(id);
		
		repository.delete(customer);
		
		CustomerInfoDeleteResponse response = new CustomerInfoDeleteResponse();
		response.setCode(OPERATION_SUCCESSFUL);
		response.setMessage("You have successfully deleted a customer.");
		
		return response;
	}
	
	private Customer customerRecordIntegrityCheck(String id) throws CustomerNotFoundException {
		Customer customer = repository.findOne(Long.parseLong(id));
		
		if(customer == null) {
			throw new CustomerNotFoundException("Customer not found in database");
		}
		
		return customer;
	}
}
