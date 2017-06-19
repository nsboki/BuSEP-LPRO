package com.laxablo.spring.sql.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laxablo.spring.sql.entity.CustomerEntity;
import com.laxablo.spring.sql.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	private List<CustomerEntity> customers = new ArrayList<CustomerEntity>();
	
	public List<CustomerEntity> getAllCustomers(){
		customers.clear();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}
	
	public CustomerEntity getCustomer(Long id) {
		return customerRepository.findOne(id);
	}
	
	public CustomerEntity save(CustomerEntity entity){
		return customerRepository.save(entity);
	}

}
