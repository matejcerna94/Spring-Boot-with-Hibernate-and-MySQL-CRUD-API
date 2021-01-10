package com.matejcerna.testapplication.testapplication.service;

import java.util.List;

import com.matejcerna.testapplication.testapplication.model.Customer;

public interface CustomerService {
	
	List<Customer> get();
	Customer get(int customer_id);
	void save(Customer customer);
	void delete(int customer_id);

}
