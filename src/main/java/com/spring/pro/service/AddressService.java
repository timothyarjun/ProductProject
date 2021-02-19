package com.spring.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.pro.entity.Address;
import com.spring.pro.repository.AddressRepository;
import com.spring.pro.repository.CustomerRepository;

@Service
public class AddressService {
	private AddressRepository addressRepository;
	private CustomerRepository customerRepository;

	@Autowired
	public AddressService(AddressRepository addressRepository, CustomerRepository customerRepository) {
		super();
		this.addressRepository = addressRepository;
		this.customerRepository = customerRepository;
	}
	
	public Address saveAddress(Address address) {
			address.setCustomer(customerRepository.getOne(address.getCustomerid()));
			//address.getCustomer().setAddress(address);
			return addressRepository.save(address);				
	}
	
	public Address findOne(long id) {
		if(id != 0)
		return addressRepository.getOne(id);
		else
			return new Address();
	}
	
	public List<Address> getAll(){
		return addressRepository.findAll();
	}
	
	public String deleteAddress(long id) {
		if(addressRepository.getOne(id) != null) {
			addressRepository.deleteById(id);
			return "address removied";
		}
		return "Address id is Invalid";		
	}
}
