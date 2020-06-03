package com.fungroup.app.service;

import com.fungroup.app.dao.CustomerDao;
import com.fungroup.app.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerService(@Qualifier("fakeDao") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    public Customer addCustomer(Customer customer){
        return customerDao.insertCustomer( customer  );
    }

    public List<Customer> getAllCustomer(){
        return customerDao.selectAllCustomer();
    }

    public Optional<Customer> getCustomerById (UUID id){
        return customerDao.selectCustomerById( id );
    }
}
