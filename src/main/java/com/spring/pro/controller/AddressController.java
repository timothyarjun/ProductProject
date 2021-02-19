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
import org.springframework.web.bind.annotation.RestController;

import com.spring.pro.entity.Address;
import com.spring.pro.service.AddressService;

@RestController
@RequestMapping("/address/api")
public class AddressController {
	private AddressService addressService;
	
	@Autowired
	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveAddress(@RequestBody Address address) {
		return new ResponseEntity<String>(addressService.saveAddress(address).toString(),HttpStatus.OK);
	}
	
	@GetMapping("/getOne/{id}")
	public Address getAddress(@PathVariable("id") long addressId) {
		return addressService.findOne(addressId);
	}
	
	@GetMapping("/allAddress")
	public List<Address> allAddress(){
		return addressService.getAll();
	}
	
	@DeleteMapping("/rmAddress{id}")
	public String removeAddress(@PathVariable long id) {
		return addressService.deleteAddress(id);
	}
	
//	@PutMapping("/updateAddress")
//	public String updateAddress(@RequestBody Address address) {
//		if(addressService.findOne(address.getId()) != null) {
//			Address a=new Address();
//			a.setId(address.getId());
//			a.setStreet(address.getStreet());
//			a.setCity(address.getCity());
//			a.setState(address.getState());
//			a.setCountry(address.getCountry());			
//			a.setPincode(address.getPincode());			
//			return addressService.saveAddress(a).toString();
//		}
//		else {
//			return "bad Request updated Failed";
//		}		
//	}
	
}
