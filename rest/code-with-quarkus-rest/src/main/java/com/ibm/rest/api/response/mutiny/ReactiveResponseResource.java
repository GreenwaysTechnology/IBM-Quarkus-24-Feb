package com.ibm.rest.api.response.mutiny;

import com.ibm.rest.api.entity.Product;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("reactive")
public class ReactiveResponseResource {

    @GET
    public Uni<List<Product>> getProducts() {
        System.out.println(Thread.currentThread().getName());
        List<Product> products = List.of(
                new Product(1, "Tooth Paste", 1233.00),
                new Product(2, "Too brush", 123.00),
                new Product(3, "Shaving cream", 500.00),
                new Product(1, "Soap", 340.00));
        return Uni.createFrom().item(products);
    }

}
