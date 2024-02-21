package com.ibm.rest.api.context;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.UriInfo;

@Path("context")
public class ContextResource {

    @Path("/urlinfo")
    @GET
    public String getUrlInfo(@Context UriInfo uriInfo) {
        String absPath = uriInfo.getAbsolutePath().toString();
        String baseUri = uriInfo.getBaseUri().toString();
        String pathParameters = uriInfo.getPathParameters().toString();
        String requestUri= uriInfo.getRequestUri().toString();

        return  absPath + baseUri + pathParameters + requestUri;
    }
    //Header information
    @GET
    @Path("/headers")
    public String getHeaderInfo(@Context HttpHeaders httpHeaders){
        return  httpHeaders.getRequestHeaders().toString();
    }
}
