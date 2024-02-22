package com.ibm.services.interfaces;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("books")
public class BookResource {

    @Inject
    ISBNGenerator isbnGenerator;

    @GET
    public String getISBN(){
        return  isbnGenerator.generateISBNNumber();
    }
}
