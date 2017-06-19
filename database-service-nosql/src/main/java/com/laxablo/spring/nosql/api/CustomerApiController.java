package com.laxablo.spring.nosql.api;

import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(method = RequestMethod.GET, value="/customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getCustomers() {

        log.info("Returning customer list.");

        return Arrays.asList(
        		"Customers List From NoSql",
                "1",
                "2",
                "3",
                "4");
    }
}
