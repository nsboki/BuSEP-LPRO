package com.laxablo.customer.service;

import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.laxablo.customer.entity.CustomerEntity;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates making a call to
 */
@Service
public class RemoteCustomerService implements CustomerService {

    @Autowired
    private KeycloakRestTemplate template;

    @NotNull
    @Value("${databasens.service.url}")
    private String endpoint;

    @Override
    public List<String> getCustomers() {
        ResponseEntity<String[]> response = template.getForEntity(endpoint, String[].class);
        System.out.println(Arrays.asList(response.getBody()));
//        return response.getBody();
        return Arrays.asList(response.getBody());
    }
    @NotNull
    @Value("${databases.service.url}")
    private String endpointS;

    @Override
    public List<CustomerEntity> getCustomersFromSql() {
    	List<CustomerEntity> entities = new ArrayList<>();

    	ResponseEntity<CustomerEntity[]> response = template.getForEntity(endpointS, CustomerEntity[].class);
        
    	Arrays.asList(response.getBody()).forEach(entities::add);

        return entities;
    }
    
    @Override
    public CustomerEntity getCustomer(Long id) {
    	ResponseEntity<CustomerEntity> response = template.getForEntity(endpointS, CustomerEntity.class);
    	return response.getBody();
    }
    
}
