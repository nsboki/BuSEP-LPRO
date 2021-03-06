package com.laxablo.customer.api;

import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.laxablo.customer.entity.CustomerEntity;
import com.laxablo.customer.service.CustomerService;

import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Customer portal controller.
 */
@Controller
@CacheControl(policy = CachePolicy.NO_CACHE)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @NotNull
    @Value("${product.service.url}")
    private String productServiceUrl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleHomePageRequest(Model model) {
        return "home";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String handleCustomersRequest(Principal principal, Model model) {
        System.out.println(customerService.getCustomers());
    	model.addAttribute("customers", customerService.getCustomers());
        model.addAttribute("principal",  principal);
        return "customers";
    }
    @RequestMapping(value = "/sqlCustomers", method = RequestMethod.GET)
    public String handleSqlCustomersRequest(Principal principal, Model model) {
    	List<String> entities = new ArrayList<>();	
    	for (CustomerEntity entity : customerService.getCustomersFromSql()) {
			entities.add(entity.getName());
    	}
    	model.addAttribute("sqlCustomers", entities);
        model.addAttribute("principal",  principal);
        return "sqlCustomers";
    }
    
    @RequestMapping(value= "/customers/{id}", method = RequestMethod.GET)
    public String handleGetCustomer(Principal principal, Model model, @PathVariable Long id) {
    	model.addAttribute("customer", customerService.getCustomer(id));
        model.addAttribute("principal",  principal);
        return "customer";
        
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String handleAdminRequest(Principal principal, Model model) {
        model.addAttribute("principal",  principal);
        return "admin";
    }

    @ModelAttribute("productServiceUrl")
    public String populateProductServiceUrl() {
        return productServiceUrl;
    }

    @ModelAttribute("serviceName")
    public String populateServiceName() {
        return "Customer Portal";
    }
}
