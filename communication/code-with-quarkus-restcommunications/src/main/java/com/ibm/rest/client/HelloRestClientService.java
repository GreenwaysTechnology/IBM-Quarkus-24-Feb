package com.ibm.rest.client;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("hello")
//@RegisterRestClient
@RegisterRestClient(configKey = "hello-api")
public interface HelloRestClientService {
    //APIS OF CALLEE
//    @GET
//    String sayHello();
    @GET
    Uni<String> sayHello();

    @POST
    String save(Greet greet);
}
