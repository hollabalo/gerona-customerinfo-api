package com.recruitit.customer.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

	@JsonProperty
	private String houseBrgy;
	
	@JsonProperty
	private String city;
	
	@JsonProperty
	private String province;

	public Address() {}
	
	public Address(String houseBrgy, String city, String province) {
		this.houseBrgy = houseBrgy;
		this.city = city;
		this.province = province;
	}
	
	public String getHouseBrgy() {
		return houseBrgy;
	}

	public void setHouseBrgy(String houseBrgy) {
		this.houseBrgy = houseBrgy;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((houseBrgy == null) ? 0 : houseBrgy.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (houseBrgy == null) {
			if (other.houseBrgy != null)
				return false;
		} else if (!houseBrgy.equals(other.houseBrgy))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		return true;
	}
	
	
}
