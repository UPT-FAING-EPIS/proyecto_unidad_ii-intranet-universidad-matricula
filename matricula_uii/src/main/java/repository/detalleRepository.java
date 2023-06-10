/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import entidad.detalle;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author LEGION
 */
@ApplicationScoped
public class detalleRepository implements PanacheMongoRepository<detalle>{
    
     public detalle findByIdmatricula(ObjectId idmatricula){
    return find("idmatricula", idmatricula).firstResult();
    }
    
    public List<detalle> findOrderedIdmatricula(){
    return listAll(Sort.by("idmatricula"));
   
    }}
