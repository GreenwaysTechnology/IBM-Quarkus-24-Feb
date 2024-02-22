package com.ibm.services.interfaces;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("hello")
public class HelloImpl implements Greeter {
    @Override
    public String sayGreet() {
        return "Hello";
    }
}
