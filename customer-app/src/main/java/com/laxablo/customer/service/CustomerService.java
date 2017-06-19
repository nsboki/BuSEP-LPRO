package com.laxablo.customer.service;

import java.util.List;

import com.laxablo.customer.entity.CustomerEntity;

/**
 * Created by Boki
 */
public interface CustomerService {

    /**
     * Returns a list of customers.
     */
    List<String> getCustomers();

	List<CustomerEntity> getCustomersFromSql();

	CustomerEntity getCustomer(Long id);
}
