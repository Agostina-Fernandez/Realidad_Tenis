package RealidadTenis.Modelo;

import java.time.LocalDate;

/**
 *
 * @author Agostina
 */
public class Contrato {
    private int idContrato;
    private Patrocinador patrocinador;
    private Jugador jugador;
    private String articulo;
    private String elemento;
    private LocalDate inicioContrato;
    private LocalDate finContrato;
    private boolean activo;
    
    /* CONSTRUCTORES */
    
    public Contrato(){}

    public Contrato(Patrocinador patrocinador, Jugador jugador, String elemento, LocalDate inicioContrato, LocalDate finContrato, boolean activo) {
        this.patrocinador = patrocinador;
        this.jugador = jugador;
        this.elemento = elemento;
        this.inicioContrato = inicioContrato;
        this.finContrato = finContrato;
        this.activo = activo;
    }

    public Contrato(int idContrato, Patrocinador patrocinador, Jugador jugador, String elemento, LocalDate inicioContrato, LocalDate finContrato, boolean activo) {
        this.idContrato = idContrato;
        this.patrocinador = patrocinador;
        this.jugador = jugador;
        this.elemento = elemento;
        this.inicioContrato = inicioContrato;
        this.finContrato = finContrato;
        this.activo = activo;
    }
    
    /* SETTERS */

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public void setInicioContrato(LocalDate inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public void setFinContrato(LocalDate finContrato) {
        this.finContrato = finContrato;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    /* GETTERS */

    public int getIdContrato() {
        return idContrato;
    }
    
    public String getArticulo(){
        return articulo;
    }
    
    public void setArticulo(String articulo){
        this.articulo = articulo;
    }
    
    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public String getElemento() {
        return elemento;
    }

    public LocalDate getInicioContrato() {
        return inicioContrato;
    }

    public LocalDate getFinContrato() {
        return finContrato;
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return "Contrato{" + "idContrato=" + idContrato + ", patrocinador=" + patrocinador + ", jugador=" + jugador + ", elemento=" + elemento + ", inicioContrato=" + inicioContrato + ", finContrato=" + finContrato + ", activo=" + activo + '}';
    }
}
