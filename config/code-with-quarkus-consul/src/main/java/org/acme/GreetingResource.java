package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "greeting.message", defaultValue = "Hello from default")
    String message;

    @ConfigProperty(name="user.app.name",defaultValue = "devoops")
    String user;

    @GET
    public String sayHello() {
        return message + " "+ user;
    }
}
