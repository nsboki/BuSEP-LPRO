package com.laxablo.customer.service;

import java.util.List;

/**
 * Created by Boki
 */
public interface CustomerService {

    /**
     * Returns a list of customers.
     */
    List<String> getCustomers();

	List<String> getCustomersFromSql();
}
