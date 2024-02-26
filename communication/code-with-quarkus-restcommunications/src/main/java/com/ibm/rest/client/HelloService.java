package com.ibm.rest.client;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloService {
//    public String hello(){
//        return "Hello Service";
//    }
    public Uni<String> hello(){
        return  Uni.createFrom().item("Hello Uni Service");
    }

    public String save(Greet greet){
        System.out.println(greet);
        return  "Saved";
    }
}
