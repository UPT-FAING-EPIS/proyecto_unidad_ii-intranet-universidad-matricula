/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.bson.types.ObjectId;

public class deuda extends PanacheMongoEntity{
    
    public ObjectId idmatricula;
    public String descripcion;
    public BigDecimal monto;
    public String dependencia;
    public LocalDate vencimiento;

    public deuda() {
    }

    public deuda(ObjectId idmatricula, String descripcion, BigDecimal monto, String dependencia, LocalDate vencimiento) {
        this.idmatricula = idmatricula;
        this.descripcion = descripcion;
        this.monto = monto;
        this.dependencia = dependencia;
        this.vencimiento = vencimiento;
    }
    
    
}
