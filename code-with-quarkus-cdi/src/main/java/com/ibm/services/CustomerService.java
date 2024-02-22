package com.ibm.services;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerService {

    public  String findAll(){
        return "Customer";
    }
}
