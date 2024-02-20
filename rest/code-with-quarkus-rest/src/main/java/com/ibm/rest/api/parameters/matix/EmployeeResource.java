package com.ibm.rest.api.parameters.matix;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;

//localhost:8080/employees/info;project=goldMining;client=Xyz
@Path("employees")
public class EmployeeResource {

    @Path("/info")
    @GET
    public String getEmployeeInfo(@MatrixParam("project") String project,@MatrixParam("client") String client){
        return  project + " " + client;
    }
}
