package RealidadTenis.Modelo;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Agostina
 */
public class Encuentro {
    private int idEncuentro;
    private Torneo torneo;
    private Cancha cancha;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador ganador;
    private LocalDate fecha;
    private LocalTime hora;
    private int resultadoJ1;
    private int resultadoJ2;
    private String estado;
    private boolean activo = true;
    private boolean programado;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    /* CONSTRUCTORES */
    
    public Encuentro(){
    }

    public Encuentro(Torneo torneo, Cancha cancha, Jugador jugador1, Jugador jugador2, Jugador ganador, String fecha, LocalTime hora, int resultadoJ1, int resultadoJ2, String estado, boolean activo, boolean programado) {
        this.torneo = torneo;
        this.cancha = cancha;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.ganador = ganador;
        this.hora = hora;
        this.resultadoJ1 = resultadoJ1;
        this.resultadoJ2 = resultadoJ2;
        this.estado = estado;
        this.activo = activo;
        this.programado = programado;
        this.fecha = LocalDate.parse(fecha, formato);
    }
    
    public Encuentro(int idEncuentro, Torneo torneo, Cancha cancha, Jugador jugador1, Jugador jugador2, Jugador ganador, String fecha, LocalTime hora, int resultadoJ1, int resultadoJ2, String estado, boolean activo, boolean programado){
        this(torneo, cancha, jugador1, jugador2, ganador, fecha, hora, resultadoJ1, resultadoJ2, estado, activo, programado);
        
        this.idEncuentro = idEncuentro;
    }
    
    /* SETTERS */

    public void setIdEncuentro(int idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public void setFechaString(String fecha) {
        this.fecha = LocalDate.parse(fecha, formato);
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setResultadoJ1(int resultadoJ1) {
        this.resultadoJ1 = resultadoJ1;
    }

    public void setResultadoJ2(int resultadoJ2) {
        this.resultadoJ2 = resultadoJ2;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setProgramado(boolean programado) {
        this.programado = programado;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setFormato(DateTimeFormatter formato) {
        this.formato = formato;
    }
    
    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }
    
    /* GETTERS */

    public int getIdEncuentro() {
        return idEncuentro;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }
    
    public Jugador getGanador() {
        return ganador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public int getResultadoJ1() {
        return resultadoJ1;
    }

    public int getResultadoJ2() {
        return resultadoJ2;
    }

    public String getEstado() {
        return estado;
    }

    public boolean isProgramado() {
        return programado;
    }

    public boolean isActivo() {
        return activo;
    }

    public DateTimeFormatter getFormato() {
        return formato;
    }

    @Override
    public String toString() {
        return "Encuentro{" + "idEncuentro=" + idEncuentro + ", torneo=" + torneo + ", cancha=" + cancha + ", jugador1=" + jugador1 + ", jugador2=" + jugador2 + ", fecha=" + fecha + ", hora=" + hora + ", resultadoJ1=" + resultadoJ1 + ", resultadoJ2=" + resultadoJ2 + ", estado=" + estado + ", programado=" + programado + ", formato=" + formato + '}';
    }
}
