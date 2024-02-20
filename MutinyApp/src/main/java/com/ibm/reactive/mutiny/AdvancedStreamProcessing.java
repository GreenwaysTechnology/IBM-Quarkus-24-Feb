package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Multi;

public class AdvancedStreamProcessing {
    public static void main(String[] args) {
        Multi.createFrom().range(1, 25)
                .filter(item -> item % 2 == 0)
                .select().first(5)
                .select().distinct()
                .subscribe().with(System.out::println);
    }
}
