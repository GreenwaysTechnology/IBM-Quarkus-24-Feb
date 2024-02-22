package com.ibm.services.interfaces;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Random;

@ApplicationScoped
public class ISBNGenerator implements NumberGenerator{
    @Override
    public String generateISBNNumber() {
        return "1223-23232323" + Math.abs(new Random().nextInt());
    }
}
