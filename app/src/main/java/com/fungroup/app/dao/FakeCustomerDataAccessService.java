package com.fungroup.app.dao;

import com.fungroup.app.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository  ("fakeDao")
public class FakeCustomerDataAccessService implements CustomerDao {

   private static List<Customer> DB = new ArrayList<>( );

    @Override
    public Customer insertCustomer(UUID id, Customer customer) {
        Customer c = new Customer( id, customer.getName() );
        DB.add( c );
        return c;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return DB;
    }

    @Override
    public Optional<Customer> selectCustomerById(UUID id) {
        return DB.stream()
                .filter( customer -> customer.getId().equals( id ) )
                .findFirst();
    }

    @Override
    public int deleteCustomerById(UUID id) {
        return 0;
    }

    @Override
    public int updateCustomerById(UUID id, Customer customer) {
        return 0;
    }

}
