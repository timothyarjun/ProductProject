package com.spring.pro.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pro.entity.Customer;
import com.spring.pro.repository.CustomerRepository;

@Service
public class CustomerService {
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	public String logIn(String userName, String password, String usertype) {
		Customer customer=customerRepository.findByUsername(userName);
		if(customer.getPassword().equals(password) && customer.getUsertype().equals(usertype))
			return "LogIn Success";
		else
			return "logIn Failed";
	}
	
	public String saveCustomer(Customer customer) {
		return customerRepository.save(customer).toString();
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> listAll(){
		return customerRepository.findAll();
	}
	
	public Customer getOne(long id) {
		return customerRepository.getOne(id);
	}
	
	public String delCustomer(Long id) {
		 customerRepository.deleteById(id);
		 return "Customer Data Removed Successfully";
	}
}
