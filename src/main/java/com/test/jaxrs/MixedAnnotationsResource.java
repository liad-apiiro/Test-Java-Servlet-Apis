package com.test.jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * BAD PRACTICES: Resource with mixed and conflicting annotations
 * - Multiple @Path annotations
 * - Conflicting method annotations
 * - Ambiguous mappings
 */
@Path("/jaxrs/mixed")
public class MixedAnnotationsResource {
    
    @GET
    @POST
    // BAD: Multiple HTTP method annotations on same method
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrPost() {
        return Response.ok("{\"method\": \"GET or POST\", \"warning\": \"Ambiguous mapping\"}").build();
    }
    
    @Path("/conflict")
    @GET
    @Path("/another")
    // BAD: Multiple @Path annotations - last one wins, but confusing
    @Produces(MediaType.APPLICATION_JSON)
    public Response conflictingPaths() {
        return Response.ok("{\"path\": \"/another\", \"warning\": \"Multiple @Path annotations\"}").build();
    }
    
    @GET
    @PUT
    @DELETE
    // BAD: Three different HTTP methods on same method
    @Produces(MediaType.APPLICATION_JSON)
    public Response multipleMethods() {
        return Response.ok("{\"method\": \"GET, PUT, or DELETE\", \"warning\": \"Too many methods\"}").build();
    }
    
    // BAD: Method without any HTTP method annotation
    @Path("/broken")
    @Produces(MediaType.APPLICATION_JSON)
    public Response brokenMethod() {
        return Response.ok("{\"error\": \"No HTTP method specified\"}").build();
    }
}

