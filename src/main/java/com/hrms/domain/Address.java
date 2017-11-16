package com.hrms.domain;

public class Address {
	
	private long id;
	private String state;
	private String street;
	private String zip;
	
	public Address() { }
	
	public Address(String state, String street, String zip) {
		this.state = state;
		this.street = street;
		this.zip = zip;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}

}
