package com.ibm.services.interfaces;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("greet")
public class HelloAndHaiResource {
    @Inject
    @Named("hello")
    Greeter greeter;

    @GET
    public String sayGreet() {
        return greeter.sayGreet();
    }
}
