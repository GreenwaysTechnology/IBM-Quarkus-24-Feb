package com.ibm.activerecord.resources;

import com.ibm.activerecord.entity.Customer;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("customers")
public class CustomerResource {

    @Inject
    CustomerService customerService;

    @GET
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GET
    @Path("{id}")
    public Customer findById(@PathParam("id") Integer id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            throw new WebApplicationException("Customer Id of " + id + "does not exits");
        }
        return customer;
    }

    @POST
    public Response save(Customer customer) {
        if (customer.id != null) {
            throw new WebApplicationException("Customer was not received");
        }
        customerService.create(customer);
        return Response.ok(customer).status(201).build();
    }

    //update
    @PUT
    @Transactional
    @Path("{id}")
    public Customer update(@PathParam("id") Integer id, Customer customer) {
        if (customer.name == null) {
            throw new WebApplicationException("Customer Name does not exits");
        }
        Customer customerEntity = Customer.findById(id);
        if (customerEntity == null) {
            throw new WebApplicationException("Customer Id of " + id + "does not exits");
        }
        //update logic
        customerEntity.name = customer.name;
        customerEntity.city = customer.city;
        return customerEntity;
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public Response deleteById(@PathParam("id") Integer id) {
        Customer customer = Customer.findById(id);
        if (customer == null) {
            throw new WebApplicationException("Customer Id of " + id + "does not exits");
        }
        customer.delete();
        return Response.noContent().build();
    }

}
