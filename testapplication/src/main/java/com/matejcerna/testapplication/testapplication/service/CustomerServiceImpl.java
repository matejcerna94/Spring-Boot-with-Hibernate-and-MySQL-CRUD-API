package com.matejcerna.testapplication.testapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matejcerna.testapplication.testapplication.dao.CustomerDAO;
import com.matejcerna.testapplication.testapplication.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Transactional
	@Override
	public List<Customer> get() {
		return customerDAO.get();
	}

	@Transactional
	@Override
	public Customer get(int customer_id) {
		return  customerDAO.get(customer_id);
	}

	@Transactional
	@Override
	public void save(Customer customer) {
		customerDAO.save(customer);
		
	}

	@Transactional
	@Override
	public void delete(int customer_id) {
		customerDAO.delete(customer_id);
		
	}

}
