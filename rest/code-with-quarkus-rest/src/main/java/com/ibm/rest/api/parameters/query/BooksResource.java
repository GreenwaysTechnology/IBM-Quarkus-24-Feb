package com.ibm.rest.api.parameters.query;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

//GET /books?pages=20
@Path("books")
public class BooksResource {

    @GET
    public String getPages(@QueryParam("pages") @DefaultValue("20") Integer pages){
        return "Total pages are " + pages;
    }
}
