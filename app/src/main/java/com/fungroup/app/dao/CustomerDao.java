package com.fungroup.app.dao;

import com.fungroup.app.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerDao {

    Customer insertCustomer (UUID id, Customer customer);
    default Customer insertCustomer(Customer customer){
        UUID id = UUID.randomUUID();
        return insertCustomer( id, customer );

    }
    List<Customer> selectAllCustomer();

    Optional<Customer> selectCustomerById(UUID id);
    int deleteCustomerById(UUID id);

    int updateCustomerById(UUID id, Customer customer);


}
