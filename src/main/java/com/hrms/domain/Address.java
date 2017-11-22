package com.hrms.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ADDRESS")
public class Address implements Serializable {

	private static final long serialVersionUID = -6160454593302408050L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	
	@NotEmpty
	@Size(min = 2, max = 2)
	@Column(name = "STATE")
	private String state;
	
	@NotEmpty
	@Column(name = "STREET")
	private String street;
	
	@NotEmpty
	@Column(name = "ZIP")
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
