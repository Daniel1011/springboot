package com.fungroup.app.api;

import com.fungroup.app.model.Customer;
import com.fungroup.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("customers")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

    @PostMapping(path = "/new")
    public Customer addCustomer(@RequestBody Customer customer){

        return customerService.addCustomer( customer );
    }

    @GetMapping
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping(path = "{id}")
    public Customer getCustomerById (@PathVariable("id") UUID id){
        return customerService.getCustomerById( id )
                .orElse( null    );
    }

}
