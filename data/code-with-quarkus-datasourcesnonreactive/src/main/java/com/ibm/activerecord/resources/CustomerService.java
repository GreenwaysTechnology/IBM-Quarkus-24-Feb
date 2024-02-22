package com.ibm.activerecord.resources;

import com.ibm.activerecord.entity.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class CustomerService {

    public List<Customer> findAll() {
        return Customer.listAll();
    }

    public Customer findById(Integer id) {
        Customer customer = Customer.findById(id);
        return customer;
    }

    @Transactional
    public void create(Customer customer) {
        customer.persist();
    }
}
