package org.acme;

import com.ibm.services.GreetingService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("welcome")
public class WelcomeResource {
    private GreetingService greetingService;

    public WelcomeResource() {
    }

    @Inject
    public WelcomeResource(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    //    public GreetingService getGreetingService() {
//        return greetingService;
//    }
//
//    @Inject
//    public void setGreetingService(GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }

    @GET
    public String sayHello(){
        return  greetingService.hello();
    }
}
