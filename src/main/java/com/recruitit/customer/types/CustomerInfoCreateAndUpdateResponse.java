package com.recruitit.customer.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "code", "message", "customerInfo" })
public class CustomerInfoCreateAndUpdateResponse extends CustomerInfoCommon {

	@JsonProperty
	private int code;
	
	@JsonProperty
	private String message;
	
	@JsonProperty(value="customerInfo")
	private CustomerInfo customerInfo;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	
	
}
