package com.ibm.vertx.event.bus;

import io.quarkus.vertx.ConsumeEvent;
import jakarta.enterprise.context.ApplicationScoped;

//Listener
@ApplicationScoped
public class CustomerService {
    //listener method
    @ConsumeEvent("ibm.customer.service.list")
    public String findAll(String id) {
        System.out.println(id);
        return "Customer Service" + id;
    }
}
