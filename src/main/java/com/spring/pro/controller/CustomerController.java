package com.spring.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pro.entity.Customer;
import com.spring.pro.service.CustomerService;

@RestController
@RequestMapping("/customer/api")
public class CustomerController {
	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> logIn(@RequestParam String userName, @RequestParam String password, @RequestParam String usertype){
		return new ResponseEntity<String>(customerService.logIn(userName,password,usertype),HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> customerRegister(@RequestBody Customer customer) {
		if(customer.getId()== 0)
		return new ResponseEntity<String>(customerService.saveCustomer(customer).toString(), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Customer>> customerList(){
		return new ResponseEntity<List<Customer>>(customerService.listAll(),HttpStatus.OK);
	}
	
	@GetMapping("/getcustomer/{id}")	
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") long id){
		if(id != 0)
			return new ResponseEntity<Customer>(customerService.getOne(id),HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	@PutMapping("/updatecustomer")
	public ResponseEntity<Customer> modifyCustomer(@RequestBody Customer customer){
		System.out.println();
		
		if(customerService.getOne(customer.getId()) != null)
		{
			Customer c = new Customer();
			c.setId(customer.getId());
			c.setUsername(customer.getUsername());
			c.setPassword(customer.getPassword());
			c.setUsertype(customer.getUsertype());
			c.setFirstName(customer.getFirstName());
			c.setLastName(customer.getLastName());
			c.setAge(customer.getAge());
			c.setDOB(customer.getDOB());
			c.setPhone(customer.getPhone());
			c.setEmail(customer.getEmail());
			c.setPrime(customer.isPrime());
			c.setReview(customer.getReview());
			
			return new ResponseEntity<Customer>(customerService.updateCustomer(c),HttpStatus.OK);	
		}
		else {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
			
	}
	
	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id){
		if(customerService.getOne(id)!=null)
			return new ResponseEntity<String>(customerService.delCustomer(id),HttpStatus.OK);	
		else
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
	
}
