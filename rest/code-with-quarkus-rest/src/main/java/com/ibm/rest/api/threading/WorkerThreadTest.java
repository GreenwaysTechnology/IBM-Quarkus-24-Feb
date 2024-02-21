package com.ibm.rest.api.threading;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("workerthread")
public class WorkerThreadTest {

    @GET
    public String runOnWorkerPool(){
        System.out.println(Thread.currentThread().getName());
        return "Hello";
    }
}
