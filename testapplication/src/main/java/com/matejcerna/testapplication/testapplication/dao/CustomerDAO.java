package com.matejcerna.testapplication.testapplication.dao;

import java.util.List;

import com.matejcerna.testapplication.testapplication.model.Customer;

public interface CustomerDAO {
	
	List<Customer> get();
	Customer get(int customer_id);
	void save(Customer customer);
	void delete(int customer_id);

}
