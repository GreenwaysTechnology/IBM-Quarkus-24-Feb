package org.acme;

import com.ibm.services.CustomerService;
import com.ibm.services.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("store")
public class StoreResource {

    @Inject
    ProductService productService;
    @Inject
    CustomerService customerService;

    @GET
    public String getStore(){
        return  customerService.findAll() + productService.findAll();
    }
}
