package com.ibm.rest.api.threading;

import com.ibm.rest.api.entity.Product;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.time.Duration;
import java.util.List;

@Path("blocking")
public class BlockingEventLoopThread {
    @GET
    @Blocking
    public Uni<Response> getResponse() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        List<Product> products = List.of(
                new Product(1, "Tooth Paste", 1233.00),
                new Product(2, "Too brush", 123.00),
                new Product(3, "Shaving cream", 500.00),
                new Product(1, "Soap", 340.00));

        //block the thread : return result after some ms
        //Thread.sleep(1000);
        Thread.sleep(7000);

        return Uni.createFrom().item(products)
                .onItem()
                .transform(f -> Response.ok(f).header("message", "How are you"))
                .onItem()
                .transform(Response.ResponseBuilder::build);
    }

    @GET
    @Path("/reactiveschduler")
    public Uni<List<Product>> getReactiveProducts() throws InterruptedException {
        System.out.println("getReactiveProducts => " + Thread.currentThread().getName());
        List<Product> products = List.of(
                new Product(1, "Tooth Paste", 1233.00),
                new Product(2, "Too brush", 123.00),
                new Product(3, "Shaving cream", 500.00),
                new Product(1, "Soap", 340.00));
        return Uni.createFrom().item(products).onItem().delayIt().by(Duration.ofSeconds(6));
    }
}
