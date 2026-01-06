package com.test.jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * JAX-RS resource with standard HTTP methods
 */
@Path("/jaxrs/standard")
public class StandardJaxRsResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {
        return Response.ok("{\"method\": \"GET\", \"framework\": \"JAX-RS\"}").build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createData(String body) {
        return Response.ok("{\"method\": \"POST\", \"framework\": \"JAX-RS\", \"body\": " + body + "}").build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateData(String body) {
        return Response.ok("{\"method\": \"PUT\", \"framework\": \"JAX-RS\", \"body\": " + body + "}").build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteData() {
        return Response.ok("{\"method\": \"DELETE\", \"framework\": \"JAX-RS\"}").build();
    }
    
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response patchData(String body) {
        return Response.ok("{\"method\": \"PATCH\", \"framework\": \"JAX-RS\", \"body\": " + body + "}").build();
    }
    
    @OPTIONS
    @Produces(MediaType.APPLICATION_JSON)
    public Response optionsData() {
        return Response.ok("{\"method\": \"OPTIONS\", \"framework\": \"JAX-RS\", \"allowed\": [\"GET\", \"POST\", \"PUT\", \"DELETE\", \"PATCH\", \"OPTIONS\"]}")
                .header("Allow", "GET, POST, PUT, DELETE, PATCH, OPTIONS")
                .build();
    }
}

