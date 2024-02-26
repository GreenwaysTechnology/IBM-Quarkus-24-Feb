package com.ibm.vertx.event.bus;

import io.vertx.mutiny.core.eventbus.EventBus;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("notification")
public class NotficationService {

    @Inject
    EventBus eventBus;

    @GET
    @Path("/{message}")
    public String publish(String message){
        eventBus.publish("stock.notification",message);
        return  "Published";
    }
}
