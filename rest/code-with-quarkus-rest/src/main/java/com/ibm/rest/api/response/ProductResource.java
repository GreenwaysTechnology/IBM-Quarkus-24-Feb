package com.ibm.rest.api.response;

import com.ibm.rest.api.entity.Product;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public Response listProducts() {
        List<Product> products = List.of(new Product(1, "Tooth Paste", 23.333));
        return Response.ok().entity(products).status(200).header("company", "ebay").build();
    }

    @DELETE
    public void remove(){
        System.out.println("removed");
    }
}
