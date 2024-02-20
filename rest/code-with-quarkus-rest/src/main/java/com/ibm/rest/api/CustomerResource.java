package com.ibm.rest.api;


import jakarta.ws.rs.*;

@Path("customers")
public class CustomerResource {

    //apis
    @GET
    public String findAll() {
        return "Customers";
    }

    @POST
    public String save() {
        return "Save";
    }

    @PUT
    public String update() {
        return "Update";
    }

    @DELETE
    public String remove() {
        return "Remove";
    }

}
