package RealidadTenis.Modelo;

/**
 *
 * @author Agostina
 */
public class Cancha {
    private int idCancha;
    private String ciudad;
    private String direccion;
    private int ancho;
    private int largo;
    private String categoria;
    private int capacidad;
    private int numeroCancha;
    private boolean enUso;
    
    /* CONSTRUCTORES */
    
    public Cancha(){}

    public Cancha(String ciudad, String direccion, int ancho, int largo, String categoria, int capacidad, int numeroCancha, boolean enUso) {
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.ancho = ancho;
        this.largo = largo;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.numeroCancha = numeroCancha;
        this.enUso = enUso;
    }

    public Cancha(int idCancha, String ciudad, String direccion, int ancho, int largo, String categoria, int capacidad, int numeroCancha, boolean enUso) {
        this.idCancha = idCancha;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.ancho = ancho;
        this.largo = largo;
        this.categoria = categoria;
        this.capacidad = capacidad;
        this.numeroCancha = numeroCancha;
        this.enUso = enUso;
    }
    
    /* SETTERS */

    public void setIdCancha(int idCancha) {
        this.idCancha = idCancha;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setNumeroCancha(int numeroCancha) {
        this.numeroCancha = numeroCancha;
    }

    public void setEnUso(boolean enUso) {
        this.enUso = enUso;
    }
    
    /* GETTERS */

    public int getIdCancha() {
        return idCancha;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getNumeroCancha() {
        return numeroCancha;
    }

    public boolean isEnUso() {
        return enUso;
    }

    @Override
    public String toString() {
        return "Cancha{" + "idCancha=" + idCancha + ", ciudad=" + ciudad + ", direccion=" + direccion + ", ancho=" + ancho + ", largo=" + largo + ", categoria=" + categoria + ", capacidad=" + capacidad + ", numeroCancha=" + numeroCancha + ", enUso=" + enUso + '}';
    }
}
