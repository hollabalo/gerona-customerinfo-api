package com.recruitit.customer.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class CustomerInfoCommon {

	@JsonProperty
	private String referenceId;

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	
	
}
