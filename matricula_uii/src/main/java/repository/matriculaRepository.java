/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import entidad.matricula;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
/**
 *
 * @author LEGION
 */
@ApplicationScoped
public class matriculaRepository implements PanacheMongoRepository<matricula>{
    
     public matricula findByIdusuario(int idusuario){
    return find("idusuario", idusuario).firstResult();
    }
    
    public List<matricula> findOrderedIdusuario(){
    return listAll(Sort.by("idusuario"));
    
    }
}
