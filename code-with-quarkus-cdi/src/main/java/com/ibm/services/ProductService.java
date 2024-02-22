package com.ibm.services;


import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductService {

    public  String findAll(){
        return  "Products";
    }
}
