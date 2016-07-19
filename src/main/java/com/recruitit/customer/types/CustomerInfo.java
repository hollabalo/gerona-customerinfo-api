package com.recruitit.customer.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "customerId", "customerName", "address", "telephone" })
public class CustomerInfo {

	@JsonProperty(value="customerId")
	private long id;
	
	@JsonProperty
	private Name customerName;
	
	@JsonProperty
	private Address address;
	
	@JsonProperty
	private String telephone;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
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
