package com.matejcerna.testapplication.testapplication.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matejcerna.testapplication.testapplication.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Customer> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> list = query.getResultList();
		return list;
	}

	@Override
	public Customer get(int customer_id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Customer customerObj = currentSession.get(Customer.class, customer_id);
		return customerObj;
	}

	@Override
	public void save(Customer customer) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public void delete(int customer_id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Customer customerObj = currentSession.get(Customer.class, customer_id);
		currentSession.delete(customerObj);
	}

}
