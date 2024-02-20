package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class FirstProgram {
    public static void main(String[] args) {
        Uni.createFrom().item("hello").subscribe().with(item->{
            System.out.println(item);
        },err->{
            System.out.println(err);
        });
    }
}
