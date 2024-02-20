package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class ErrorHandling {
    public static void main(String[] args) {
        Uni.createFrom()
                .failure(new RuntimeException("something went wrong"))
                .onFailure().recoverWithItem("fallback")
                .subscribe().with(err -> System.out.println(err));
    }
}
