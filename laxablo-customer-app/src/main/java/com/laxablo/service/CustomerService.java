package com.laxablo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.laxablo.entity.CustomerEntity;
import com.laxablo.repository.CustomerRepository;

/**
 * 
 * @author Boki
 *
 */

public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<CustomerEntity> getAllCustomers() {
		List<CustomerEntity> customers = new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}
	public void addCustomer(CustomerEntity entity) {
		customerRepository.save(entity);
	}
	
	
}
