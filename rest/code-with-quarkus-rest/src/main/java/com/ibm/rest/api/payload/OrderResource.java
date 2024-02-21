package com.ibm.rest.api.payload;

import com.ibm.rest.api.entity.Order;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("orders")
public class OrderResource {

    //Return single Object
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrder(){
        return  new Order(1,"Pending",33434.89,"this is nice product");
    }

    //List of orders
    @GET
    @Path("/list")
    public List<Order> getOrders(){
        return List.of(
                new Order(1, "pending", 1000.334, "Contains electronics"),
                new Order(2, "delivered", 455434.90, "Contains electronics"),
                new Order(3, "dispatched", 233434.4555, "Contains electronics"),
                new Order(4, "InTransit", 122323.89, "Contains electronics"),
                new Order(5, "pending", 7800.334, "Contains electronics")
        );
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String create(Order order){
        System.out.println(order);
        return order.toString();
    }
}
