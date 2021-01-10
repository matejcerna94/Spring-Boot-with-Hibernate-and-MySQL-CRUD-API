package com.matejcerna.testapplication.testapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matejcerna.testapplication.testapplication.model.Customer;
import com.matejcerna.testapplication.testapplication.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer")
	public List<Customer> get() {
		return customerService.get();		
	}
	
	@PostMapping("/customer")
	public Customer save(@RequestBody Customer customerObj) {
		customerService.save(customerObj);
		return customerObj;
	}
	
	@GetMapping("/customer/{customer_id}")
	public Customer get(@PathVariable int customer_id) {
		Customer customerObj = customerService.get(customer_id);
		if(customerObj == null) {
			throw new RuntimeException("Customer with ID " + customer_id + " not found!");
		}
		return customerObj;
	}
	
	@DeleteMapping("/customer/{customer_id}")
	public String delete(@PathVariable int customer_id) {
		customerService.delete(customer_id);
		return "Customer has been deleted with ID:" + customer_id;
	}
	
	@PutMapping("/customer")
	public Customer update(@RequestBody Customer customerObj) {
		customerService.save(customerObj);
		return customerObj;
	}

}
