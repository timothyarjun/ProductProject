package com.spring.pro.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer extends Audit{	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private int age;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date DOB;
	
	private String phone;
	private String email;
	private boolean isPrime;
	private String review;
	
	//private transient long addressId;
	
	//@JsonManagedReference		// backward part of reference. It will fix the infinite loop issue
	@OneToOne(mappedBy = "customer")
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isPrime() {
		return isPrime;
	}

	public void setPrime(boolean isPrime) {
		this.isPrime = isPrime;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer(long id, String firstName, String lastName, int age, Date dOB, String phone, String email,
			boolean isPrime, String review, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		DOB = dOB;
		this.phone = phone;
		this.email = email;
		this.isPrime = isPrime;
		this.review = review;
		this.address = address;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", DOB="
				+ DOB + ", phone=" + phone + ", email=" + email + ", isPrime=" + isPrime + ", review=" + review
				+ ", address=" + address + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getAge()=" + getAge() + ", getDOB()=" + getDOB()
				+ ", getPhone()=" + getPhone() + ", getEmail()=" + getEmail() + ", isPrime()=" + isPrime()
				+ ", getReview()=" + getReview() + ", getAddress()=" + getAddress() + "]";
	}

	
	
}
