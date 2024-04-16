package org.sample;

import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
public class CustomerController {

	static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepositorySpring repository;
	
    @RequestMapping(method=RequestMethod.GET,value="/customer/{id}")
    @Operation(
            summary = "Get Customer",
	 		description = "Get a Customer by id")    
	public Customer getCustomer(
		@PathVariable(value="id") @NonNull String id
    		) {

    
        Optional<Customer> c = repository.findById(id);
    	
        if (!c.isPresent()) {
            throw new CustomerNotFoundException();
        }

        return c.get();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customer")
    @Operation(summary = "Create a Customer", description = "Create a Customer serialized in JSON")
    public Customer putCustomer(
            @Parameter(description = "Customer object", required = true, name = "Customer") @RequestBody Customer c) {

        c.setId(UUID.randomUUID().toString());

        logger.debug("Adding customer {}", c.getId());

        return repository.save(c);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customer/{id}")
    @Operation(summary = "Delete a Customer", description = "Delete a Customer by id")
    public void deleteCustomer(@PathVariable(value = "id") @NonNull String id) {
        repository.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customer/{id}")
    @Operation(summary = "Update a Customer", description = "Update a Customer by id")
    public Customer updateCustomer(@PathVariable(value = "id") String id,
            @Parameter(description = "Customer object", required = true, name = "Customer") @RequestBody Customer c) {
                
        c.setId(id);
        Customer c_update = repository.save(c);

        return c_update;
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This customer is not found in the system")
    public class CustomerNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 100L;
    }

}