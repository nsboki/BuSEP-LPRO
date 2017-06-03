package com.laxablo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laxablo.entity.CustomerEntity;
import com.laxablo.service.CustomerService;

/**
 * 
 * @author Boki
 *
 */
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/customers")
//	public List<CustomerEntity> getAllCustomers() {
//		System.out.println("pristupa se /customers");
//		return customerService.getAllCustomers();
//	}
	public String test(){
		System.out.println("test za /customers");
		return "customers";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/customers")
	public void addCustomer(@RequestBody CustomerEntity entity){
		customerService.addCustomer(entity);
	}
	
}
