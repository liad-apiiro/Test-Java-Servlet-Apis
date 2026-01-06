package com.test.jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * JAX-RS resource with custom HTTP methods using @HttpMethod annotation
 */
@Path("/jaxrs/custom")
public class CustomMethodJaxRsResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {
        return Response.ok("{\"method\": \"GET\", \"framework\": \"JAX-RS\"}").build();
    }
    
    // Custom HTTP method using @HttpMethod
    @Path("/funkytown")
    @HttpMethod("FUNKYTOWN")
    @Produces(MediaType.APPLICATION_JSON)
    public Response funkyTown() {
        return Response.ok("{\"method\": \"FUNKYTOWN\", \"framework\": \"JAX-RS\", \"message\": \"Custom method via @HttpMethod\"}").build();
    }
    
    @Path("/danceparty")
    @HttpMethod("DANCEPARTY")
    @Produces(MediaType.APPLICATION_JSON)
    public Response danceParty() {
        return Response.ok("{\"method\": \"DANCEPARTY\", \"framework\": \"JAX-RS\", \"message\": \"Another custom method\"}").build();
    }
    
    @Path("/superduper")
    @HttpMethod("SUPERDUPER")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response superDuper(String body) {
        return Response.ok("{\"method\": \"SUPERDUPER\", \"framework\": \"JAX-RS\", \"body\": " + body + "}").build();
    }
    
    // Multiple methods on same path - discouraged
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postData() {
        return Response.ok("{\"method\": \"POST\", \"framework\": \"JAX-RS\"}").build();
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response putData() {
        return Response.ok("{\"method\": \"PUT\", \"framework\": \"JAX-RS\"}").build();
    }
}

