package com.test.jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * BAD PRACTICES: JAX-RS resource with various issues
 * - Missing @Consumes/@Produces in some methods
 * - Inconsistent response types
 * - No input validation
 */
@Path("/jaxrs/problematic")
public class ProblematicJaxRsResource {
    
    @GET
    // BAD: Missing @Produces annotation
    public Response getData() {
        return Response.ok("{\"method\": \"GET\"}").build();
    }
    
    @POST
    // BAD: Missing @Consumes annotation but expects JSON
    @Produces(MediaType.APPLICATION_JSON)
    public Response createData(String body) {
        // BAD: No validation of body parameter
        return Response.ok("{\"method\": \"POST\", \"body\": \"" + body + "\"}").build();
    }
    
    @PUT
    @Path("/{id}")
    // BAD: Missing @Consumes and @Produces
    public Response updateData(@PathParam("id") String id, String body) {
        // BAD: No validation of path parameter
        // BAD: No validation of body
        return Response.ok("{\"method\": \"PUT\", \"id\": \"" + id + "\", \"body\": \"" + body + "\"}").build();
    }
    
    @DELETE
    @Path("/{id}")
    // BAD: Missing @Produces but returns JSON
    public Response deleteData(@PathParam("id") String id) {
        // BAD: No authorization check
        // BAD: No validation
        return Response.ok("{\"method\": \"DELETE\", \"id\": \"" + id + "\"}").build();
    }
    
    // BAD: Method without HTTP method annotation - will cause issues
    @Path("/broken")
    public Response brokenMethod() {
        return Response.ok("{\"error\": \"This shouldn't work\"}").build();
    }
}

