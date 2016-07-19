package com.recruitit.customerinfo.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceExceptionDetail implements Serializable {

	private static final long serialVersionUID = -5236744165761462200L;

	@JsonProperty
	private String code;
	
	@JsonProperty
	private String description;

	public ServiceExceptionDetail() {}
	
	public ServiceExceptionDetail(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
