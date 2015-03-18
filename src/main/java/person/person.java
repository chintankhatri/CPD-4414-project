/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

import Connect.Connect;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
/**
 *
 * @author c0645743
 */
@Path("/person")
public class person {

    @GET
    @Produces("application/json")
    public Response getAll() {
        return Response.ok(Connect.getResults("SELECT * FROM project")).build();
        
    }
}
