/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import Entities.Beca;
import Entities.Estado;
import Entities.Matricula;
import Entities.ProntoPago;
import Entities.Semestre;
import Entities.Usuario;
import Services.MatriculaService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author LEGION
 */

@Path("/v1/matriculas")
@Produces(MediaType.APPLICATION_JSON)
public class MatriculaController {
    
    
    private final MatriculaService matriculaService;

    @Inject
    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GET
    public List<Matricula> getMatriculas() {
        return matriculaService.getAllMatriculas();
    }

    @GET
    @Path("/{id}")
    public Matricula getMatricula(@PathParam("id") int idMatricula) throws NotFoundException {
        return matriculaService.getMatriculaById(idMatricula);
    }

    @POST
    public Matricula createMatricula(@Valid MatriculaDto matriculaDto) {
        return matriculaService.saveMatricula(matriculaDto.toMatricula());
    }

    @PUT
    @Path("/{id}")
    public Matricula updateMatricula(@PathParam("id") int idMatricula, @Valid MatriculaDto matriculaDto) throws NotFoundException {
        return matriculaService.updateMatricula(idMatricula, matriculaDto.toMatricula());
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMatricula(@PathParam("id") int idMatricula) throws NotFoundException {
        matriculaService.deleteMatricula(idMatricula);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public static class MatriculaDto {
    private Usuario usuario;
    private Semestre semestre;
    private ProntoPago prontoPago;
    private Beca beca;
    @Past
    private LocalDate fecha;
    private Estado estado;
    @Past
    private LocalDate vencimiento;
    private BigDecimal total;

    public Usuario getUsuario() {
        return usuario;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public ProntoPago getProntoPago() {
        return prontoPago;
    }

    public Beca getBeca() {
        return beca;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public void setProntoPago(ProntoPago prontoPago) {
        this.prontoPago = prontoPago;
    }

    public void setBeca(Beca beca) {
        this.beca = beca;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setVencimiento(LocalDate vencimiento) {
        this.vencimiento = vencimiento;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Matricula toMatricula() {
        Matricula matricula = new Matricula();
        matricula.setUsuario(usuario);
        matricula.setSemestre(semestre);
        matricula.setProntoPago(prontoPago);
        matricula.setBeca(beca);
        matricula.setFecha(fecha);
        matricula.setEstado(estado);
        matricula.setVencimiento(vencimiento);
        matricula.setTotal(total);

        return matricula;
    }
}
    
    
    
}
