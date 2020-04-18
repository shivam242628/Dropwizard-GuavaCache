package org.example.resources;

import com.codahale.metrics.annotation.Timed;
import org.example.CacheHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/cache")
@Produces(MediaType.APPLICATION_JSON)
public class CacheResource {

    public final CacheHandler cacheHandler;

    public CacheResource(CacheHandler cacheHandler) {
        this.cacheHandler = cacheHandler;
    }

    @Timed
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("")
    public Response cache() {
        System.out.println("In CacheResource.cache()...Get Student Data");
        for (int i = 1; i < 4; i++) {
            cacheHandler.getStudentData(i);
        }
        Map<String, String> response = new HashMap<>();
        response.put("message", "Student Data has been retrieved");
        return Response.ok(response).build();
    }
}
