package com.ibm.dao.resources;

import com.ibm.dao.enity.Employee;
import com.ibm.dao.repo.EmployeeRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("employees")
public class EmployeeResource {
    @Inject
    EmployeeRepository repository;

    @GET
    public List<Employee> findAll() {
        return repository.listAll();
    }

    @GET
    @Path("{id}")
    public Employee findById(@PathParam("id") Long id) {
        Employee employee = repository.findById(id);
        if (employee == null) {
            throw new WebApplicationException("Employee with ID Of " + id + "does not  exits", 404);
        }
        return employee;
    }

    //save
    @POST
    @Transactional
    public Response create(Employee employee) {
        if (employee.id != null) {
            throw new WebApplicationException("ID was invalidly set on request", 404);
        }
        repository.persist(employee);
        return Response.ok(employee).status(201).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Employee update(@PathParam("id") Long id, Employee employee) {
        if (employee.name == null || employee.city == null) {
            throw new WebApplicationException("Employee Name or city was not set on request" + 422);
        }
        Employee employeeEnity = repository.findById(id);
        if (employeeEnity == null) {
            throw new WebApplicationException("Employee with ID Of " + id + "does not  exits", 404);
        }
        employeeEnity.name = employee.name;
        employeeEnity.city = employee.city;
        return employeeEnity;
    }

    @Path("{id}")
    @Transactional
    @DELETE
    public Response delete(@PathParam("id") Long id) {
        Employee employeeEnity = repository.findById(id);
        if (employeeEnity == null) {
            throw new WebApplicationException("Employee with ID Of " + id + "does not  exits", 404);
        }
        repository.delete(employeeEnity);
        return Response.ok().status(204).build();
    }
}
