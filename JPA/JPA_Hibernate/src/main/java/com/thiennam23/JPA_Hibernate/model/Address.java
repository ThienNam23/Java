package com.thiennam23.JPA_Hibernate.model;

import javax.persistence.Embeddable;

@Embeddable // cai nay chi dinh day cung la 1 entity de tao column nhung k tao thanh table moi
public class Address {
	private String city;
	private String country;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + "]";
	}
	
}
