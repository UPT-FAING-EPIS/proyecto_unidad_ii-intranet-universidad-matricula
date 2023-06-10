/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;
import entidad.matricula;
import static io.quarkus.mongodb.panache.PanacheMongoEntityBase.findById;
import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.net.URI;
import java.net.URISyntaxException;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import repository.matriculaRepository;
/**
 *
 * @author LEGION
 */
@Path("/matriculas")
public class matriculaResource {
    @Inject
    matriculaRepository repository;
    
    @Channel("quarkus-rabbitmq")
    Emitter<JsonObject> emitter;
    
    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") String id){
    matricula matricula = repository.findById(new ObjectId(id));
    
    
    JsonObject obj=new JsonObject();
    obj.put("Matricula","Se ha listado las matriculas en base al Id.");
    emitter.send(obj);
    return Response.ok(matricula).build();
    }
    
    @GET
    public Response get(){
        
    JsonObject obj=new JsonObject();
    obj.put("Matricula","Se ha listado las matriculas.");
    emitter.send(obj);
        
     return Response.ok(repository.listAll()).build();
    }
    
    @GET
    @Path("/search/{idusuario}")
    public Response search(@PathParam("idusuario") int idusuario){
     matricula matricula = repository.findByIdusuario(idusuario);
     
     JsonObject obj=new JsonObject();
    obj.put("Matricula","Se ha listado las matriculas en base al idusuario.");
    emitter.send(obj);
     
        return matricula != null ? Response.ok(matricula).build() : Response.status(Status.NOT_FOUND).build();
    }
    
    @POST
    public Response create (matricula matricula) throws URISyntaxException{
    repository.persist(matricula);
    
    JsonObject obj=new JsonObject();
    obj.put("Matricula","Se ha creado una matricula nueva.");
    emitter.send(obj);
    return Response.created(new URI("/"+ matricula.id)).build();
    }
    
    
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, matricula matricula){
    matricula.id = new ObjectId(id);
    repository.update(matricula);
    
    JsonObject obj=new JsonObject();
    obj.put("Matricula","Se ha modificado una matricula");
    emitter.send(obj);
    
    
    return Response.ok(matricula).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id){
        matricula matricula = repository.findById(new ObjectId(id));
        repository.delete(matricula);
        
        JsonObject obj=new JsonObject();
        obj.put("Matricula","Se ha eliminado una matricula");
        emitter.send(obj);
        
        
        return Response.noContent().build();
    }
}
