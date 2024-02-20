package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class UniDataProcessing {
    public static void main(String[] args) {
        Uni.createFrom()
                .item("hello")
                .onItem()
                .transform(item -> item + "Subramanian")
                .onItem()
                .transform(item -> item.toUpperCase())
                .subscribe()
                .with(System.out::println);


    }
}
