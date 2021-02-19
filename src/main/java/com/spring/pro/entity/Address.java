package com.spring.pro.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;		
	private String street;
	private String city;
	private String state;
	private String country;
	private long pincode;
	
	private transient long customerid;	
	//@JsonBackReference   // forward part of reference. It will fix the infinite loop issue
	@OneToOne(targetEntity = Customer.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Customer customer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address(long id, String street, String city, String state, String country, long pincode, long customerid,
			Customer customer) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.customerid = customerid;
		this.customer = customer;
	}

	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", country="
				+ country + ", pincode=" + pincode + ", customer=" + customer + ", getId()=" + getId()
				+ ", getStreet()=" + getStreet() + ", getCity()=" + getCity() + ", getState()=" + getState()
				+ ", getCountry()=" + getCountry() + ", getPincode()=" + getPincode() + ", getCustomerid()="
				+ getCustomerid() + ", getCustomer()=" + getCustomer() + "]";
	}
	
	
}
