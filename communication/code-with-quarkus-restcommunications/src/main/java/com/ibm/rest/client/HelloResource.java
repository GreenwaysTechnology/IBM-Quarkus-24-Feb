package com.ibm.rest.client;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("hello")
public class HelloResource {

    @Inject
    HelloService helloService;

    //    @GET
//    public String hello(){
//        return  helloService.hello();
//    }
    @GET
    public Uni<String> hello() {
        return helloService.hello();
    }


    @POST
    public String save(Greet greet) {
        return helloService.save(greet);
    }

}
