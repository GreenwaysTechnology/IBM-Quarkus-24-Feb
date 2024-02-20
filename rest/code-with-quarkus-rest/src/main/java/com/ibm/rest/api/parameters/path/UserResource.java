package com.ibm.rest.api.parameters.path;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("users")
public class UserResource {

    //get user by id
    @GET
    @Path("/{Id}")
    public String findById(@PathParam("Id") Long id){
        return  "User " + id;
    }

}
