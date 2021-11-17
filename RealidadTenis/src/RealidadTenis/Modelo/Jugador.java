package RealidadTenis.Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Agostina
 */
public class Jugador {
    private int idJugador;
    private String nombre;
    private String apellido;
    private long dni;
    private LocalDate fechaNacimiento;
    private double altura;
    private double peso;
    private String estilo;
    private boolean diestro;
    private boolean activo;
    private int puntos;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    /* CONSTRUCTORES */
    
    public Jugador(){}

    public Jugador(String nombre, String apellido, long dni, String fechaNacimiento, double altura, double peso, String estilo, boolean diestro, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.altura = altura;
        this.peso = peso;
        this.estilo = estilo;
        this.diestro = diestro;
        this.activo = activo;
        this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formato);
    }
    
    public Jugador(int idJugador, String nombre, String apellido, long dni, String fechaNacimiento, double altura, double peso, String estilo, boolean diestro, boolean activo) {
        this(nombre, apellido, dni, fechaNacimiento, altura, peso, estilo, diestro, activo);
        
        this.idJugador = idJugador;
    }
    
    /* SETTERS */

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setDiestro(boolean diestro) {
        this.diestro = diestro;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    /* GETTERS */

    public int getIdJugador() {
        return idJugador;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public long getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public String getEstilo() {
        return estilo;
    }

    public boolean isDiestro() {
        return diestro;
    }

    public boolean isActivo() {
        return activo;
    }
    
    /* OVERRIDES */

    @Override
    public String toString() {
        return "Id: " + idJugador + " - Nombre Completo: " + nombre + " " + apellido ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.dni ^ (this.dni >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }
}
