package RealidadTenis.Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Agostina
 */
public class Torneo {
    private int idTorneo;
    private String nombreCopa;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean activo = true;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    /* CONSTRUCTORES */

    public Torneo() {
    }

    public Torneo(String nombreCopa, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombreCopa = nombreCopa;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    public Torneo(int id, String nombreCopa, LocalDate fechaInicio, LocalDate fechaFin) {
        this(nombreCopa, fechaInicio, fechaFin);
        this.idTorneo = id;
    }
    
    /* SETTERS */

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public void setNombreCopa(String nombreCopa) {
        this.nombreCopa = nombreCopa;
    }

    public void setFechaInicioString(String fechaInicio) {
        this.fechaInicio = LocalDate.parse(fechaInicio, formato);
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = LocalDate.parse(fechaFin, formato);
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    /* GETTERS */

    public int getIdTorneo() {
        return idTorneo;
    }

    public String getNombreCopa() {
        return nombreCopa;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Torneo{" + "idTorneo=" + idTorneo + ", nombreCopa=" + nombreCopa + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", activo=" + activo + ", formato=" + formato + '}';
    }
}
