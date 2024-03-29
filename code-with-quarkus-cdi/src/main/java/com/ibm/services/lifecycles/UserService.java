package com.ibm.services.lifecycles;


import io.quarkus.runtime.Shutdown;
import io.quarkus.runtime.Startup;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UserService {
    List<String> users;

    @Startup
    public void init() {
        users = List.of("Subramanian", "Admin", "Guest", "Super User");
    }

    @Shutdown
    public void destroy() {
        System.out.println("Shutdown");
    }

    public List<String> getUsers() {
        return users;
    }
}