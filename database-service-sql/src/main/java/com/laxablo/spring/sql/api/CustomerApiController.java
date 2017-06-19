package com.laxablo.spring.sql.api;

import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.laxablo.spring.sql.entity.CustomerEntity;
import com.laxablo.spring.sql.repository.CustomerRepository;
import com.laxablo.spring.sql.service.CustomerService;

import java.util.Arrays;
import java.util.List;

/**
 * Customer API controller.
 */
@RestController
//@RequestMapping("/customers")
@CacheControl(policy = CachePolicy.NO_CACHE)
public class CustomerApiController {

    private static final Logger log = LoggerFactory.getLogger(CustomerApiController.class);

    @Autowired
    private CustomerService customerService;
    
    @RequestMapping(method = RequestMethod.GET, value="/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerEntity> getCustomers() {

        log.info("Returning customer list.");
        return customerService.getAllCustomers();
    }
    
    @RequestMapping(method = RequestMethod.GET, value="/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerEntity getCustomer(@PathVariable Long id) {
    	log.info("Returning the customer with id: " + id);
    	return customerService.getCustomer(id);
    }
    
}
