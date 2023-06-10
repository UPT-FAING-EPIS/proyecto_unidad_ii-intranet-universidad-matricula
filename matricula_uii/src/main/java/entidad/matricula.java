/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author LEGION
 */
public class matricula extends PanacheMongoEntity{
    public int idusuario;
    public int idsemestre;
    public int idprontopago;
    public int idbeca;
    public LocalDate fecha;
    public int idestado;
    public LocalDate vencimiento;
    public BigDecimal total;

    public matricula() {
    }

    public matricula(int idusuario, int idsemestre, int idprontopago, int idbeca, LocalDate fecha, int idestado, LocalDate vencimiento, BigDecimal total) {
        this.idusuario = idusuario;
        this.idsemestre = idsemestre;
        this.idprontopago = idprontopago;
        this.idbeca = idbeca;
        this.fecha = fecha;
        this.idestado = idestado;
        this.vencimiento = vencimiento;
        this.total = total;
    }

    
}
