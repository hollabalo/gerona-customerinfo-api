package com.recruitit.customerinfo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.recruitit.customer.types.Address;
import com.recruitit.customer.types.CustomerInfoCreateAndUpdateResponse;
import com.recruitit.customer.types.CustomerInfoCreateRequest;
import com.recruitit.customer.types.CustomerInfoResponse;
import com.recruitit.customer.types.CustomerInfoUpdateRequest;
import com.recruitit.customer.types.Name;
import com.recruitit.customerinfo.TestApplicationConfig;
import com.recruitit.customerinfo.exception.CustomerNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {TestApplicationConfig.class})
public class CustomerInfoControllerTest {

	@Autowired
	private CustomerInfoController controller;
	
	@Test
	public void createCustomerTest() {
		CustomerInfoCreateRequest request = new CustomerInfoCreateRequest();
		request.setCustomerName(new Name("Gerona","John Michael","Dimapilis"));
		request.setAddress(new Address("0118 Tumana","Sta Maria", "Bulacan"));
		request.setTelephone("09111234567");
		
		HttpEntity<CustomerInfoCreateAndUpdateResponse> response = controller.create(request);
		
		assertNotNull(response.getBody());
		assertEquals(0, response.getBody().getCode());
	}
	
	@Test
	public void getCustomerTest() throws CustomerNotFoundException {
		HttpEntity<CustomerInfoResponse> response = controller.find("1");
		
		assertNotNull(response.getBody());
		assertEquals(1, response.getBody().getId());
	}
	
	@Test(expected=CustomerNotFoundException.class)
	public void customerNotFoundTest() throws CustomerNotFoundException {
		controller.find("5");
	}
	
	@Test
	public void updateCustomerTest() throws CustomerNotFoundException {
		CustomerInfoUpdateRequest request = new CustomerInfoUpdateRequest();
		request.setCustomerName(new Name("Hilario","Sharmaine","Hilario"));
		request.setAddress(new Address("0118 Tumana","Sta Maria", "Bulacan"));
		request.setTelephone("09111234567");
		
		String id = "2";
		
		HttpEntity<CustomerInfoCreateAndUpdateResponse> response = controller.update(id, request);
		
		assertNotNull(response.getBody());
		assertEquals(2, response.getBody().getCustomerInfo().getId());
		assertEquals(0, response.getBody().getCode());
	}
	
	@Test(expected=CustomerNotFoundException.class)
	public void updateCustomerExceptionTest() throws CustomerNotFoundException {
		CustomerInfoUpdateRequest request = new CustomerInfoUpdateRequest();
		request.setCustomerName(new Name("Gerona","John Michael","Dimapilis"));
		request.setAddress(new Address("0118 Tumana","Sta Maria", "Bulacan"));
		request.setTelephone("09111234567");
		
		String id = "5";
		
		controller.update(id, request);
	}
	
	@Test
	public void deleteCustomerTest() throws CustomerNotFoundException {
		String id = "3";
		controller.delete(id);
	}
	
	@Test(expected=CustomerNotFoundException.class)
	public void deleteCustomerExceptionTest() throws CustomerNotFoundException {
		String id = "10";
		controller.delete(id);
	}

}
