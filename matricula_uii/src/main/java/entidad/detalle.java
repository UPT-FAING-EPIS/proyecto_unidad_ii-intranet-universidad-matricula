/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import java.math.BigDecimal;
import org.bson.types.ObjectId;

/**
 *
 * @author LEGION
 */
public class detalle extends PanacheMongoEntity{
    
    public ObjectId idmatricula;
    public int idcurso;
    public BigDecimal subtotal;

    public detalle() {
    }

    public detalle(ObjectId idmatricula, int idcurso, BigDecimal subtotal) {
        this.idmatricula = idmatricula;
        this.idcurso = idcurso;
        this.subtotal = subtotal;
    }
    
    
    
}
