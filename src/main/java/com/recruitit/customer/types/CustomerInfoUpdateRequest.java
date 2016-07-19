package com.recruitit.customer.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerInfoUpdateRequest {
	
	@JsonProperty
	private Name customerName;
	
	@JsonProperty
	private Address address;
	
	@JsonProperty
	private String telephone;
	
	public Name getCustomerName() {
		return customerName;
	}

	public void setCustomerName(Name customerName) {
		this.customerName = customerName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
