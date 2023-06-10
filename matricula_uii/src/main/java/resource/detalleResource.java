/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

import entidad.detalle;
import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import repository.detalleRepository;

/**
 *
 * @author LEGION
 */
@Path("/detalles")
public class detalleResource {
    @Inject
    detalleRepository repository;
  
    
    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") String id){
    detalle detalle = repository.findById(new ObjectId(id));
      
    
    return Response.ok(detalle).build();
    }
    
    @GET
    public Response get(){
      
        
     return Response.ok(repository.listAll()).build();
    }
    
    @GET
    @Path("/search/{idmatricula}")
    public Response search(@PathParam("idmatricula") ObjectId idmatricula){
     detalle detalle = repository.findByIdmatricula(idmatricula);
 
     
        return detalle != null ? Response.ok(detalle).build() : Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @POST
    public Response create (detalle detalle) throws URISyntaxException{
    repository.persist(detalle);
    
 
    return Response.created(new URI("/"+ detalle.id)).build();
    }
    
    
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, detalle detalle){
    detalle.id = new ObjectId(id);
    repository.update(detalle);

    return Response.ok(detalle).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id){
        detalle detalle = repository.findById(new ObjectId(id));
        repository.delete(detalle);
        

        return Response.noContent().build();
    }
    
    
}
